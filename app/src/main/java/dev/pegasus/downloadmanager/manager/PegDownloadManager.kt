package dev.pegasus.downloadmanager.manager

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri
import dev.pegasus.downloadmanager.R
import dev.pegasus.downloadmanager.interfaces.Downloader

/**
 * @Author: SOHAIB AHMED
 * @Date: 7/25/2023
 * @Accounts
 *      -> https://github.com/epegasus
 *      -> https://stackoverflow.com/users/20440272/sohaib-ahmed
 */

class PegDownloadManager(context: Context) : Downloader {

    private val downloadManager by lazy { context.getSystemService(DownloadManager::class.java) }
    private val filePathImage by lazy { "${context.getString(R.string.app_name)}/IMAGE_${System.currentTimeMillis()}.png" }
    private val filePathVideo by lazy { "${context.getString(R.string.app_name)}/VIDEO_${System.currentTimeMillis()}.mp4" }

    /**
     *  @param imageUrl: Url to be download
     *  Request Header: If there's any kind of authorization, we can add replace <token> to add.
     */

    override fun downloadImage(imageUrl: String): Long {
        val request = DownloadManager.Request(imageUrl.toUri())
            .setMimeType("image/*")
            .setTitle("Downloading Image")
            .setDescription("Image is being download")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filePathImage)
            .addRequestHeader("Authorization", "Bearer <token>")
        return downloadManager.enqueue(request)
    }

    /**
     *  @param videoUrl: Url to be download
     *  Request Header: If there's any kind of authorization, we can add replace <token> to add.
     */

    override fun downloadVideo(videoUrl: String): Long {
        val request = DownloadManager.Request(videoUrl.toUri())
            .setMimeType("video/*")
            .setTitle("Downloading Video")
            .setDescription("Video is being download")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filePathVideo)
            .addRequestHeader("Authorization", "Bearer <token>")
        return downloadManager.enqueue(request)
    }
}
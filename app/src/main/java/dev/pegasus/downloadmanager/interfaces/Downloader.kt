package dev.pegasus.downloadmanager.interfaces

/**
 * @Author: SOHAIB AHMED
 * @Date: 7/25/2023
 * @Accounts
 *      -> https://github.com/epegasus
 *      -> https://stackoverflow.com/users/20440272/sohaib-ahmed
 */

interface Downloader {

    fun downloadImage(imageUrl: String): Long
    fun downloadVideo(videoUrl: String): Long

}
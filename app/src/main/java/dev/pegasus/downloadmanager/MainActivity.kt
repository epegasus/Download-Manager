package dev.pegasus.downloadmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.pegasus.downloadmanager.databinding.ActivityMainBinding
import dev.pegasus.downloadmanager.manager.PegDownloadManager

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val pegDownloadManager by lazy { PegDownloadManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mbDownload.setOnClickListener { onDownloadClick() }
    }

    private fun onDownloadClick() {
        // Download Image
        pegDownloadManager.downloadImage("https://pl-coding.com/wp-content/uploads/2022/04/pic-squared.jpg")

        // Download Video
        pegDownloadManager.downloadVideo("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4")
    }
}
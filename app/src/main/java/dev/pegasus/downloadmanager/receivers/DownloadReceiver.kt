package dev.pegasus.downloadmanager.receivers

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class DownloadReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // Check for right action (as per required
        if (intent.action != "android.intent.action.DOWNLOAD_COMPLETE") return

        val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1L)
        if (id == -1L) return

        val message = "Download completed for id: $id"
        Log.d("MyTag", "onReceive: $message")
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
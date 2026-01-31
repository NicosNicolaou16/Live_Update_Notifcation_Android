package com.nicos.liveupdatenotification.local_notification

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.pm.PackageManager
import android.graphics.drawable.Icon
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat
import com.nicos.liveupdatenotification.R

class LocalNotification(private val context: Context) {

    companion object {
        private const val CHANNEL_ID = "Channel Id"
        private const val CHANNEL_NAME = "Channel Name"
        private const val CHANNEL_DESCRIPTION = "Channel Description"

        private const val CURRENT_PROGRESS = 55
        private const val CURRENT_PROGRESS_SEGMENT_ONE = 33
        private const val CURRENT_PROGRESS_SEGMENT_TWO = 33
        private const val CURRENT_PROGRESS_SEGMENT_THREE = 33
        private const val CURRENT_PROGRESS_SEGMENT_FOUR = 33
        private const val CURRENT_PROGRESS_POINT_ONE = 33
        private const val CURRENT_PROGRESS_POINT_TWO = 66
        private const val CURRENT_PROGRESS_POINT_THREE = 99
    }

    internal fun showNotification() {
        Notification.Builder(context, CHANNEL_ID).apply {
            setSmallIcon(R.drawable.ic_android_black_24dp)
            setContentTitle(context.getString(R.string.local_notification_title))
            setContentText(context.getString(R.string.local_notification_text))
            setAutoCancel(true)

            // Begin Live Update
            val progressStyle: Notification.ProgressStyle? =
                getAndCreateProgressStyle()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.BAKLAVA && progressStyle != null) {
                setStyle(progressStyle)
            }
            // End of Live Update

            createNotificationChannel()

            with(NotificationManagerCompat.from(context)) {
                if (ActivityCompat.checkSelfPermission(
                        context,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return
                }
                notify(1, this@apply.build())
            }
        }
    }

    private fun getAndCreateProgressStyle(): Notification.ProgressStyle? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.BAKLAVA) {
            // Handle the segments
            val progressSegmentList: List<Notification.ProgressStyle.Segment> =
                handleProgressSegment()
            // Handle the points
            val progressPointList: List<Notification.ProgressStyle.Point> =
                handleProgressPoint()
            // Create the progress style
            Notification.ProgressStyle().apply {
                setStyledByProgress(false)
                // Set the current progress
                setProgress(CURRENT_PROGRESS)
                // Set the progress tracker icon
                setProgressTrackerIcon(
                    Icon.createWithResource(
                        context,
                        R.drawable.ic_android_red_24dp
                    )
                )
                // Set the segments
                setProgressSegments(
                    progressSegmentList
                )
                // Set the points
                setProgressPoints(
                    progressPointList
                )
            }
        } else {
            // TODO("VERSION.SDK_INT < BAKLAVA")
            return null
        }
    }

    @RequiresApi(Build.VERSION_CODES.BAKLAVA)
    private fun handleProgressSegment(): List<Notification.ProgressStyle.Segment> {
        return listOf(
            Notification.ProgressStyle.Segment(CURRENT_PROGRESS_SEGMENT_ONE)
                .setColor(context.getColor(R.color.teal_200)),
            Notification.ProgressStyle.Segment(CURRENT_PROGRESS_SEGMENT_TWO)
                .setColor(context.getColor(R.color.purple_200)),
            Notification.ProgressStyle.Segment(CURRENT_PROGRESS_SEGMENT_THREE)
                .setColor(context.getColor(R.color.purple_700)),
            Notification.ProgressStyle.Segment(CURRENT_PROGRESS_SEGMENT_FOUR)
                .setColor(context.getColor(R.color.teal_700))

        )
    }

    @RequiresApi(Build.VERSION_CODES.BAKLAVA)
    private fun handleProgressPoint(): List<Notification.ProgressStyle.Point> {
        return listOf(
            Notification.ProgressStyle.Point(CURRENT_PROGRESS_POINT_ONE)
                .setColor(context.getColor(android.R.color.holo_green_light)),
            Notification.ProgressStyle.Point(CURRENT_PROGRESS_POINT_TWO)
                .setColor(context.getColor(android.R.color.holo_green_light)),
            Notification.ProgressStyle.Point(CURRENT_PROGRESS_POINT_THREE)
                .setColor(context.getColor(android.R.color.holo_green_light))
        )
    }

    private fun createNotificationChannel() {
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance).apply {
            description = CHANNEL_DESCRIPTION
            with((context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager)) {
                createNotificationChannel(this@apply)
            }
        }
    }
}
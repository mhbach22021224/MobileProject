package com.example.myapplication

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.BroadcastReceiver
import android.content.Context
import android.widget.RemoteViews

class MyWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        // Lặp qua tất cả các widget và cập nhật chúng
        appWidgetIds?.forEach { appWidgetId ->
            val views = RemoteViews(context?.packageName, R.layout.widget_layout)
            views.setTextViewText(R.id.widget_text, "Hello Widget!")

            // Gửi cập nhật đến widget
            appWidgetManager?.updateAppWidget(appWidgetId, views)
        }
    }
}

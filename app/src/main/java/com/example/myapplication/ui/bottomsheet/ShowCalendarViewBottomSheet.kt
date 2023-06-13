package com.example.myapplication.ui.bottomsheet

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import com.example.myapplication.R
import com.example.myapplication.databinding.CalenderViewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ShowCalendarViewBottomSheet : BottomSheetDialogFragment() {
    private lateinit var binding: CalenderViewBinding

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("RestrictedApi", "ClickableViewAccessibility")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)

        val contentView = View.inflate(context, R.layout.calender_view, null)
        binding = CalenderViewBinding.bind(contentView)
        dialog.setContentView(contentView)

        with(binding) {
            calendarView.setHeaderColor(R.color.colorAccent)
            ivBack.setOnClickListener(View.OnClickListener { dialog.dismiss() })
        }
    }

    override fun onDestroyView() = super.onDestroyView()

}

package com.senex.timetable.parser

import android.content.Context
import android.net.Uri
import androidx.core.net.toFile
import com.senex.timetable.R
import com.senex.timetable.common.log
import org.apache.poi.ss.usermodel.*
import java.io.File
import java.io.FileOutputStream

class Parser(private val appContext: Context) {
    fun parse() {
        val uri: Uri = Uri.parse("android.resource://" + appContext.packageName + "/raw/" + "table")
        log(uri.path)

        val timetableFile = File("/raw/table")
        val wb = WorkbookFactory.create(timetableFile)

        val creationHelper: CreationHelper = wb.creationHelper
        val sheet: Sheet = wb.createSheet("new sheet")

        // Create a row and put some cells in it. Rows are 0 based.

        val row: Row = sheet.createRow(0)
        // Create a cell and put a value in it.
        // Create a cell and put a value in it.
        val cell: Cell = row.createCell(0)
        cell.setCellValue(1.0)

        //numeric value
        row.createCell(1).setCellValue(1.2)

        //plain string value
        row.createCell(2).setCellValue("This is a string cell")

        row.createCell(3).setCellValue("Kotlin")

        //boolean value
        //boolean value
        row.createCell(4).setCellValue(true)

        //formula
        //formula
        row.createCell(5).setCellFormula("SUM(A1:B1)")


        FileOutputStream(timetableFile).use { fileOut -> wb.write(fileOut) }

    }

}
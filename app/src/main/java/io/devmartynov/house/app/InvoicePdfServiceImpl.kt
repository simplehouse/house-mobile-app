package io.devmartynov.house.app

import android.content.Context
import android.graphics.pdf.PdfDocument
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Environment
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import io.devmartynov.house.R
import io.devmartynov.house.app.helpers.Utils
import io.devmartynov.house.domain.model.InvoiceEntity
import io.devmartynov.house.domain.model.PdfService
import io.devmartynov.house.ui.screen.invoices.model.InvoicePdfFileInfo
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject
import io.devmartynov.house.app.model.Result
import io.devmartynov.house.domain.model.Service
import io.devmartynov.house.domain.model.ServiceInvoiceEntity

class InvoicePdfServiceImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : PdfService {

    private fun buildFileName(invoiceCreateTime: String): String {
        return "house_service_invoice_${
            Utils.formatDateString(
                date = invoiceCreateTime,
                patternTo = "dd_MM_yyyy"
            )
        }.pdf"
    }

    override fun generatePdf(invoice: InvoiceEntity): Result<InvoicePdfFileInfo> {
        val pageHeight = 600
        val pageWidth = 800

        val pdfDocument = PdfDocument()

        val paint = Paint()
        val titlePaint = Paint()

        val pageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, 1).create()
        val page = pdfDocument.startPage(pageInfo)
        val pageCanvas: Canvas? = page.canvas

        titlePaint.typeface = Typeface.create(
            Typeface.DEFAULT,
            Typeface.NORMAL
        )
        titlePaint.textAlign = Paint.Align.CENTER
        titlePaint.textSize = 15F
        titlePaint.color = ContextCompat.getColor(context, R.color.black)
        pageCanvas?.drawText(
            context.resources.getString(
                R.string.label_invoice_pdf,
                Utils.formatDateString(invoice.createTime)
            ),
            (pageWidth / 2).toFloat(),
            80F,
            titlePaint
        )

        paint.color = ContextCompat.getColor(context, R.color.black)
        paint.strokeWidth = 1f
        paint.style = Paint.Style.STROKE

        // прямоугольник - каркас таблицы
        val horizontalRight = (pageWidth - 100).toFloat()
        val horizontalBottom = 230f
        val horizontalLeft = 100f
        pageCanvas?.drawRect(horizontalLeft, 130f, horizontalRight, horizontalBottom, paint)


        // горизонатльные линии таблицы
        pageCanvas?.drawLine(horizontalLeft, 150f, horizontalRight, 150f, paint)
        pageCanvas?.drawLine(horizontalLeft, 170f, horizontalRight, 170f, paint)
        pageCanvas?.drawLine(horizontalLeft, 190f, horizontalRight, 190f, paint)
        pageCanvas?.drawLine(horizontalLeft, 210f, horizontalRight, 210f, paint)

        // вертикальные линии таблицы
        val verticalStartY = 130f
        pageCanvas?.drawLine(250f, verticalStartY, 250f, horizontalBottom, paint)
        pageCanvas?.drawLine(400f, verticalStartY, 400f, horizontalBottom, paint)
        pageCanvas?.drawLine(550f, verticalStartY, 550f, horizontalBottom, paint)


        // Текст в таблице
        titlePaint.textSize = 10F
        pageCanvas?.drawText(
            context.resources.getString(R.string.label_table_service),
            175f,
            143f,
            titlePaint
        )
        pageCanvas?.drawText(
            context.resources.getString(R.string.label_table_service_value),
            325f,
            143f,
            titlePaint
        )
        pageCanvas?.drawText(
            context.resources.getString(R.string.label_table_service_amount),
            475f,
            143f,
            titlePaint
        )

        invoice.servicesData.forEachIndexed { index: Int, serviceInvoiceEntity: ServiceInvoiceEntity ->
            val serviceTitleY = ((170 + index * 20) - 7).toFloat()
            pageCanvas?.drawText(
                context.resources.getString(
                    Service.values()[serviceInvoiceEntity.id - 1].label
                ),
                175f,
                serviceTitleY,
                titlePaint
            )
            pageCanvas?.drawText(
                "${serviceInvoiceEntity.value}",
                325f,
                serviceTitleY,
                titlePaint
            )
            pageCanvas?.drawText(
                "${serviceInvoiceEntity.amountToPay}",
                475f,
                serviceTitleY,
                titlePaint
            )
        }
        pageCanvas?.drawText(
            context.resources.getString(
                R.string.label_table_services_amount,
                invoice.getToPayAmount().toString()
            ),
            475f,
            223f,
            titlePaint
        )

        pdfDocument.finishPage(page)

        val fileName = buildFileName(invoice.createTime)
        val file = File(
            Environment.getExternalStorageDirectory(),
            "/${Environment.DIRECTORY_DOWNLOADS}/$fileName",
        )

        try {
            file.createNewFile()
        } catch (e: Exception) {
            e.printStackTrace()
            pdfDocument.close()
            return Result.Failure(e.message.toString())
        }

        try {
            pdfDocument.writeTo(FileOutputStream(file))
        } catch (e: Exception) {
            e.printStackTrace()
            pdfDocument.close()
            return Result.Failure(e.message.toString())
        }

        pdfDocument.close()

        return Result.Success(
            InvoicePdfFileInfo(
                fileName = file.name,
                filePath = file.absolutePath,
            )
        )
    }
}
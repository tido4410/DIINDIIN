package diiin.ui

import android.annotation.SuppressLint
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import diiin.util.MathService

/**
 * RVWithFLoatingButtonControl defines a method to hide the floating action button when
 * user does some action.
 * @author Gabriel Moro
 * @since 11/09/2018
 * @version 1.0.9
 */
class RVWithFLoatingButtonControl(albaFloatingButtonTarget: FloatingActionButton) : View.OnTouchListener {

    private val mfaFloatingButtonTarget: FloatingActionButton = albaFloatingButtonTarget

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(p0: View?, amotionEvent: MotionEvent?): Boolean {
        when (amotionEvent?.action) {
            MotionEvent.ACTION_MOVE ->
                mfaFloatingButtonTarget.visibility = FloatingActionButton.GONE
            else -> {
                mfaFloatingButtonTarget.visibility = FloatingActionButton.VISIBLE
            }
        }
        return false
    }
}

/**
 * TWEditPrice is the component used as textwatcher in currency edit texts,
 * this component autoadjust the integer numbers to currency value.
 *
 * @author Gabriel Moro
 * @since 11/09/2018
 * @version 1.0.9
 *
 * @param aetPrice is the edittext component
 */
class TWEditPrice(aetPrice: EditText) : TextWatcher {

    private val metPrice: EditText = aetPrice
    private var bIgnoreOnTextChange: Boolean = false

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    /**
     * Each user interaction this method will be called, to put some currency markers in
     * the text.
     *
     * @param p0 is the current string
     */
    override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
        if (!bIgnoreOnTextChange) {
            val strText = p0.toString()
                    .replace(",", "")
                    .replace(".", "")
                    .replace("R$", "")
            val nNumber = strText.toIntOrNull() ?: return
            val strMoney = MathService.formatIntToCurrencyValue(nNumber)
            bIgnoreOnTextChange = true
            metPrice.setText(strMoney)
            metPrice.setSelection(strMoney.length)
            bIgnoreOnTextChange = false
        }
    }

    override fun afterTextChanged(p0: Editable) {}
}



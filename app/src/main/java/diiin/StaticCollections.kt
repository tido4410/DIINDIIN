package diiin

import diiin.dao.DataBaseFactory
import diiin.model.MonthType

/**
 * This singleton class is created to store in runtime
 * the user preferences and shared preferences loaded
 * according the users interaction.
 *
 * @author Gabriel Moro
 * @since 24/08/2018
 * @version 1.0.9
 */
object StaticCollections {

    var mappDataBuilder : DataBaseFactory? = null
    /**
     * Represents the month selected in the filter by user
     */
    var mmtMonthSelected : MonthType? = null
    /**
     * Represent the current year.
     */
    var mnYearSelected : Int = 2018

    val mstrDateFormat : String = "dd-MM-yyyy"

}
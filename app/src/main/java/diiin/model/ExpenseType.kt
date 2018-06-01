package diiin.model

import android.content.Context
import android.support.v4.content.ContextCompat
import br.com.gbmoro.diiin.R

/**
 * Define the type of expense used by objects from Expense class
 *
 * @author Gabriel Moro
 *
 * @param idExpense is the Expense type identifier
 */
enum class ExpenseType(val idExpense : Int){
    FOOD(1),
    TRANSPORT(2),
    PHONE(3),
    PETS(4),
    EDUCATION(5),
    HEALTH(6),
    FUN(7),
    RENT(8),
    TRAVEL(9),
    OTHERS(110);

    companion object {
        /**
         * This map connect the id and types
         */
        private val map = ExpenseType.values().associateBy(ExpenseType::idExpense)

        /**
         * Return some expense type according to integer id
         * @param type is the integer id
         */
        fun fromInt(type : Int) = map[type]

        /**
         *
         * The method returns the expense type id according some string
         * description.
         *
         * @param actContext is the screen context
         * @param asrValue is the description of the expense type
         */
        fun gettingIdFromDescription(actContext: Context, asrValue : String) : Int? {
            return when(asrValue) {
                FOOD.description(actContext) -> FOOD.idExpense
                TRANSPORT.description(actContext) -> TRANSPORT.idExpense
                PHONE.description(actContext) -> PHONE.idExpense
                FUN.description(actContext) -> FUN.idExpense
                PETS.description(actContext) -> PETS.idExpense
                EDUCATION.description(actContext) -> EDUCATION.idExpense
                HEALTH.description(actContext) -> HEALTH.idExpense
                RENT.description(actContext) -> RENT.idExpense
                TRAVEL.description(actContext) -> TRAVEL.idExpense
                OTHERS.description(actContext) -> OTHERS.idExpense
                else -> null
            }
        }
    }

    /**
     * This method returns the description according expense type
     * defined by constructor
     *
     * @param actContext is the screen context
     */
    fun description(actContext : Context) : String {
        return when(this) {
            FOOD -> actContext.resources.getString(R.string.food)
            TRANSPORT -> actContext.resources.getString(R.string.transport)
            PHONE -> actContext.resources.getString(R.string.phone)
            PETS -> actContext.resources.getString(R.string.pets)
            EDUCATION -> actContext.resources.getString(R.string.education)
            HEALTH -> actContext.resources.getString(R.string.health)
            FUN -> actContext.resources.getString(R.string.funn)
            RENT -> actContext.resources.getString(R.string.rent)
            TRAVEL -> actContext.resources.getString(R.string.travel)
            OTHERS -> actContext.resources.getString(R.string.other)
        }
    }

    fun imageIconId() : Int {
        return when(this) {
            FOOD -> R.drawable.ic_food
            TRANSPORT -> R.drawable.ic_transport
            PHONE -> R.drawable.ic_phone
            PETS -> R.drawable.ic_pets
            EDUCATION -> R.drawable.ic_education
            HEALTH -> R.drawable.ic_health
            FUN -> R.drawable.ic_fun
            RENT -> R.drawable.ic_rent
            TRAVEL -> R.drawable.ic_travel
            OTHERS -> R.drawable.ic_others

        }
    }


    /**
     * This method returns the background color according expense type defined by constructor
     *
     * @param actContext is the screen context
     */
    fun backgroundColor(actContext : Context) : Int {
        return when(this) {
            FOOD -> ContextCompat.getColor(actContext, R.color.foodbkg)
            TRANSPORT -> ContextCompat.getColor(actContext, R.color.transportbkg)
            PHONE -> ContextCompat.getColor(actContext, R.color.phonebkg)
            PETS -> ContextCompat.getColor(actContext, R.color.petsbkg)
            EDUCATION -> ContextCompat.getColor(actContext, R.color.educationbkg)
            HEALTH -> ContextCompat.getColor(actContext, R.color.healthbkg)
            FUN -> ContextCompat.getColor(actContext, R.color.funnbkg)
            RENT -> ContextCompat.getColor(actContext, R.color.rentbkg)
            TRAVEL -> ContextCompat.getColor(actContext, R.color.travelbkg)
            OTHERS -> ContextCompat.getColor(actContext, R.color.othersbkg)
        }
    }

}
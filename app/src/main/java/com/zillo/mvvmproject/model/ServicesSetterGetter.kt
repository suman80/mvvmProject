
//This is a model class which is used to handle API Response

data class ServicesSetterGetterItem(

    val author: String,
    val download_url: String,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)

class ServicesSetterGetter : ArrayList<ServicesSetterGetterItem>()

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.zillo.mvvmproject.R
import com.zillo.mvvmproject.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.item_view.view.*

class ImageRecyclerAdapter(val viewModel: MainActivityViewModel, val arrayList: ServicesSetterGetter, val context: Context): RecyclerView.Adapter<ImageRecyclerAdapter.ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageRecyclerAdapter.ImageViewHolder {

        var root = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return ImageViewHolder(root)
    }

    override fun onBindViewHolder(holder: ImageRecyclerAdapter.ImageViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        if(arrayList.size==0){
            Toast.makeText(context,"List is empty",Toast.LENGTH_LONG).show()
        }else{

        }
        return arrayList.size
    }

    inner  class ImageViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {

        fun bind(blog: ServicesSetterGetterItem){
                    Glide.with(context)
                        .load(blog.download_url)  //Loading image url from server side
                        .diskCacheStrategy(DiskCacheStrategy.ALL)  //It is used for the caching purpose ie when internet is off
                        .into(binding.image);
        }
    }
}
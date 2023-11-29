import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinegames.Adapter.MmorpgAdapter
import com.example.onlinegames.Api.RetrofitClient
import com.example.onlinegames.Data.Datagames
import com.example.onlinegames.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MmorpgFragment : Fragment() {
    //template code
    private val list = ArrayList<Datagames>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate this fragment file xml
        return inflater.inflate(R.layout.fragment_mmorpg, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //place the code here
        val rv = view.findViewById<RecyclerView>(R.id.rev)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(context)

        RetrofitClient.instance.mmorpg().enqueue(object : Callback<ArrayList<Datagames>>{
            override fun onResponse(
                call: Call<ArrayList<Datagames>>,
                response: Response<ArrayList<Datagames>>
            ) {
                response.body()?.let { list.addAll(it) }
                val adapter = MmorpgAdapter(list)
                rv.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<Datagames>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}
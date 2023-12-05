import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinegames.Adapter.ActionAdapter
import com.example.onlinegames.Api.RetrofitClient
import com.example.onlinegames.Data.Datagames
import com.example.onlinegames.R
import com.example.onlinegames.UI.DetailActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ActionFragment : Fragment() {
    //template code
    private val list = ArrayList<Datagames>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate this fragment file xml
        return inflater.inflate(R.layout.fragment_action, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //place the code here

        val rv = view.findViewById<RecyclerView>(R.id.rev2)
        rv.layoutManager = LinearLayoutManager(context)
        rv.setHasFixedSize(true)
        RetrofitClient.instance.action().enqueue(object : Callback<ArrayList<Datagames>>{
            override fun onResponse(
                call: Call<ArrayList<Datagames>>,
                response: Response<ArrayList<Datagames>>
            ) {
                response.body()?. let { list.addAll(it) }
                val adapter = ActionAdapter(list)
                rv.adapter = adapter

                adapter.setOnItemclickcallback(object : ActionAdapter.onItemClick{
                    override fun onItemclick(datagames: Datagames) {
                        val intent = Intent(context, DetailActivity::class.java)
                        intent.putExtra("data",datagames)
                        startActivity(intent)
                    }

                })
            }

            override fun onFailure(call: Call<ArrayList<Datagames>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}
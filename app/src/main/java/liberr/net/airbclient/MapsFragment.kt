package liberr.net.airbclient

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MapsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MapsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapsFragment : Fragment() {

    private var googleMap: GoogleMap? = null

    private var mListener: OnFragmentInteractionListener? = null
    private var mMapPositionListener: OnChangeMapPositionListener? = null

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    interface  OnChangeMapPositionListener {
        fun onChangeMapPosition(lat: Double, lng: Double)
    }

    companion object {
        fun newInstance(): MapsFragment {
            val fragment = MapsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }

        val Home = LatLng(38.26575431103936, 140.87288305163383)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onResume() {
        super.onResume()
        setUpMapIfNeeded()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener && context is OnChangeMapPositionListener) {
            mListener = context
            mMapPositionListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener and OnChangeMapPositionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
        mMapPositionListener = null
    }

    private fun setUpMapIfNeeded() {
        if (googleMap == null) {
            val mapFragment = childFragmentManager.findFragmentById(R.id.map) as MapFragment
            mapFragment.getMapAsync { setUpMap(it) }
        }
    }

    private fun setUpMap(map: GoogleMap) {
        googleMap = map
        googleMap!!.uiSettings.isZoomControlsEnabled = true//拡大縮小ボタン表示

        val camerapos = CameraPosition.Builder()//表示位置の作成
        camerapos.target(Home)//カメラの表示位置の指定
        camerapos.zoom(13.0f)//ズームレベル
        camerapos.bearing(0f)//カメラの向きの指定(北向きなので０）
        camerapos.tilt(25.0f)//カメラの傾き設定
        googleMap!!.moveCamera(CameraUpdateFactory.newCameraPosition(camerapos.build()))//マップの表示位置変更
        val options = MarkerOptions()//ピンの設定
        options.position(Home)//ピンの場所を指定
        options.title("金閣寺")//マーカーの吹き出しの設定
        googleMap!!.addMarker(options)//ピンの設置

        googleMap!!.setOnCameraIdleListener({
            if (googleMap != null) {
                val cameraPosition = (googleMap as GoogleMap).cameraPosition
                val latLng = cameraPosition.target
                Log.d(MainActivity::class.java.simpleName, "lat: ${latLng.latitude}, lng: ${latLng.longitude}")
                mMapPositionListener!!.onChangeMapPosition(latLng.latitude, latLng.longitude)
            }
        })

    }
}


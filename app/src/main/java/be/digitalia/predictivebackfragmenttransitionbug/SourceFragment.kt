package be.digitalia.predictivebackfragmenttransitionbug

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class SourceFragment : Fragment(R.layout.fragment_source) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logoView: View = view.findViewById(R.id.android_logo)
        logoView.setOnClickListener {
            val fm = requireActivity().supportFragmentManager
            fm.commit {
                setReorderingAllowed(true)
                addSharedElement(logoView, logoView.transitionName)
                replace<DestinationFragment>(R.id.content)
                addToBackStack(null)
            }
        }
    }
}
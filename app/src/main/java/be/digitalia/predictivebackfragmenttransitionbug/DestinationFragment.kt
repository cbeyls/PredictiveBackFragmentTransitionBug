package be.digitalia.predictivebackfragmenttransitionbug

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.ChangeTransform
import androidx.transition.Fade
import androidx.transition.TransitionSet

class DestinationFragment : Fragment(R.layout.fragment_destination) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = Fade()
        exitTransition = Fade()
        sharedElementEnterTransition = TransitionSet().apply {
            addTransition(
                ChangeBounds()
            )
            // Using ChangeTransform() for a shared element transition breaks predictive back animation.
            // But without it, the ImageView won't animate properly between containers.
            addTransition(
                ChangeTransform()
            )
        }
    }
}
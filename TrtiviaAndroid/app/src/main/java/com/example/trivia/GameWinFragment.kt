package com.example.trivia

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import com.example.trivia.databinding.FragmentGameOverBinding
import com.example.trivia.databinding.FragmentGameWinBinding


class GameWinFragment : Fragment() {
    lateinit var binding: FragmentGameWinBinding

    var totalQuestions = 0;
    var correctAnswers = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentGameWinBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        arguments?.let {
            val args = GameOverFragmentArgs.fromBundle(it)
            totalQuestions = args.totalQuestions
            correctAnswers = args.correctAnswers
        }
        Toast.makeText(this.activity,getString(R.string.success_text,correctAnswers,totalQuestions),Toast.LENGTH_SHORT).show()
    }
    private fun getShareIntent():Intent
    {

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT,getString(R.string.success_text,correctAnswers,totalQuestions))
        return shareIntent
    }
    private fun shareSuccess()
    {
        startActivity(getShareIntent())
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}
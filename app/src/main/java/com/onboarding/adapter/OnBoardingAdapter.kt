package com.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_2_5m.databinding.ItemOnboardingBinding
import com.onboarding.OnBoardingModel
import com.squareup.picasso.Picasso

class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf(
        OnBoardingModel(
            "https://img.freepik.com/vetores-premium/casal-de-desenhos-animados-homem-e-mulher-segurando-um-cartao-de-coracao-nas-maos_599908-35.jpg?w=740",
            "Have a good time",
            "You should take the time to help those who need you"
        ),
        OnBoardingModel(
            "https://static.vecteezy.com/system/resources/previews/019/816/907/non_2x/cute-couple-in-love-man-kissing-and-embracing-woman-isolated-man-and-woman-vector.jpg",
            "Cherishing love",
            "It is now no longer possible for you to cherish love "
        ),
        OnBoardingModel(
            "https://img.freepik.com/premium-vector/valentine-s-day-girl-hugs-guy-couple-love-vector-cartoon-style_313437-42.jpg?w=360",
            "Have a breakup ? ",
            "We have made the correction for you don't worry" +
                    "Maybe someone is waiting for you"
        ),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingAdapter.OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoardingModel) {
            Picasso.get()
                .load(onBoarding.image)
                .into(binding.imgBoard)
            binding.tvBoard.text = onBoarding.title
            binding.tvBdTitle.text = onBoarding.description
            binding.btnStart.setOnClickListener {
                onClick()
            }
        }
    }

}
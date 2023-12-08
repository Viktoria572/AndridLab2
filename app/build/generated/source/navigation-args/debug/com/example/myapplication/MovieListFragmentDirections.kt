package com.example.myapplication

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class MovieListFragmentDirections private constructor() {
  private data class ActionMovieListFragmentToMovieDetailFragment(
    public val movie: Movie
  ) : NavDirections {
    public override val actionId: Int = R.id.action_movieListFragment_to_movieDetailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Movie::class.java)) {
          result.putParcelable("movie", this.movie as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Movie::class.java)) {
          result.putSerializable("movie", this.movie as Serializable)
        } else {
          throw UnsupportedOperationException(Movie::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionMovieListFragmentToMovieDetailFragment(movie: Movie): NavDirections =
        ActionMovieListFragmentToMovieDetailFragment(movie)
  }
}

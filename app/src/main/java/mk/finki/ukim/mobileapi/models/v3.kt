package mk.finki.ukim.mobileapi.models

class v3 {
    val title:String
    val movies : Movie
    constructor(title: String, movies: Movie) {
        this.title = title
        this.movies = movies
    }

}
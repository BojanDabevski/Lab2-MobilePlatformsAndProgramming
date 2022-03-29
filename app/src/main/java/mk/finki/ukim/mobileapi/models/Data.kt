package mk.finki.ukim.mobileapi.models

class Data {

     val id: Long
     val title:String
     val description:String
     val director:String
     val actors:String

    constructor(id: Long, title: String, description: String, director: String, actors: String) {
        this.id = id
        this.title = title
        this.description = description
        this.director = director
        this.actors = actors
    }
}
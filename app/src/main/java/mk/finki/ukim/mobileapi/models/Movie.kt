package mk.finki.ukim.mobileapi.models

class Movie {
    public val data: MutableList<Data>



    constructor(data: MutableList<Data>) {
        this.data = data
    }
}
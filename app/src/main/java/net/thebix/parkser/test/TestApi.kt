package net.thebix.parkser.test

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface TestApi {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Observable<Response<List<TestItemResponse>>>
}

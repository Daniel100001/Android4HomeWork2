//package com.example.android4homework1.base
//
//import android.net.Uri
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.example.android4homework1.data.remote.apiservices.MangaApiService
//import com.example.android4homework1.models.rickAndMortyCharacter.MangaModel
//import retrofit2.HttpException
//import java.io.IOException
//
//private const val CHARACTER_STARTING_PAGE_INDEX = 1
//
//abstract class BasePagingSource(private var service: ) : PagingSource<Int,MangaModel>(){
//
//     suspend fun loadBase(params: LoadParams<Int>): LoadResult<Int, MangaModel> {
//        val position = params.key ?: CHARACTER_STARTING_PAGE_INDEX
//        return try {
//            val response = service.fetchCharacters(params.loadSize,position)
//            val next = response.links.next
//            val nextPageNumber =
//                Uri.parse(next).getQueryParameter("page[offset]")!!.toInt()
//            LoadResult.Page(
//                data = response.data,
//                prevKey = null,
//                nextKey = nextPageNumber
//            )
//        } catch (exception: IOException) {
//            return LoadResult.Error(exception)
//        } catch (exception: HttpException) {
//            return LoadResult.Error(exception)
//        }
//    }
//
//     fun getRefreshKeyBase(state: PagingState<Int, MangaModel>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
//        }
//    }
//}
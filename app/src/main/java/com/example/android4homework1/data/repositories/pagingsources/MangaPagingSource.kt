package com.example.android4homework1.data.repositories.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android4homework1.data.remote.apiservices.MangaApiService
import com.example.android4homework1.models.rickAndMortyCharacter.MangaModel
import retrofit2.HttpException
import java.io.IOException

private const val CHARACTER_STARTING_PAGE_INDEX = 1

class MangaPagingSource(private var service: MangaApiService) : PagingSource<
        Int, MangaModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MangaModel> {
        val position = params.key ?: CHARACTER_STARTING_PAGE_INDEX
        val pageSize = params.loadSize
        return try {
            val response = service.fetchCharacters(pageSize, position)
            val next = response.links.next
            val nextPageNumber =
                Uri.parse(next).getQueryParameter("page[offset]")!!.toInt()
            LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = nextPageNumber
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MangaModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
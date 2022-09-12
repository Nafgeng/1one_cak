package com.nafgeng.appleapi.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseCak(

	@field:SerializedName("length")
	val length: Int? = null,

	@field:SerializedName("lastpost")
	val lastpost: Int? = null,

	@field:SerializedName("posts")
	val posts: List<PostsItem>? = null
) : Parcelable

@Parcelize
data class PostsItem(

	@field:SerializedName("gif")
	val gif: Int? = null,

	@field:SerializedName("nsfw")
	val nsfw: Int? = null,

	@field:SerializedName("src")
	val src: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable

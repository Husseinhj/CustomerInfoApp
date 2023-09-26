package com.husseinhj.customerinfoapp.presentation.common.avatar_view

import androidx.databinding.BindingAdapter

@BindingAdapter("avatar_url")
fun bindUserAvatarUrl(userAvatarView: UserAvatarView, url: String?) {
    userAvatarView.avatarUrl = url ?: ""
}
@BindingAdapter("avatar_alt")
fun bindUserAvatarAlt(userAvatarView: UserAvatarView, alt: String?) {
    userAvatarView.avatarAlt = alt ?: ""
}
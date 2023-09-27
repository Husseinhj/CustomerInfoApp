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

@BindingAdapter("avatar_first_name", "avatar_last_name", requireAll = true)
fun bindMakeAltForAvatar(userAvatarView: UserAvatarView, firstName: String?, lastName: String?) {
    val firstCharOfName = firstName?.firstOrNull() ?: ""
    val firstCharOfLastName = lastName?.firstOrNull() ?: ""

    userAvatarView.avatarAlt = "$firstCharOfName$firstCharOfLastName"
}

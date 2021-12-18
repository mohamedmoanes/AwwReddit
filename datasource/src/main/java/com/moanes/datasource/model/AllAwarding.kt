package com.moanes.datasource.model


import com.google.gson.annotations.SerializedName

data class AllAwarding(
    @SerializedName("award_sub_type")
    var awardSubType: String,
    @SerializedName("award_type")
    var awardType: String,
    @SerializedName("awardings_required_to_grant_benefits")
    var awardingsRequiredToGrantBenefits: Any?,
    @SerializedName("coin_price")
    var coinPrice: Int,
    @SerializedName("coin_reward")
    var coinReward: Int,
    @SerializedName("count")
    var count: Int,
    @SerializedName("days_of_drip_extension")
    var daysOfDripExtension: Int,
    @SerializedName("days_of_premium")
    var daysOfPremium: Int,
    @SerializedName("description")
    var description: String,
    @SerializedName("end_date")
    var endDate: Any?,
    @SerializedName("giver_coin_reward")
    var giverCoinReward: Int?,
    @SerializedName("icon_format")
    var iconFormat: String?,
    @SerializedName("icon_height")
    var iconHeight: Int,
    @SerializedName("icon_url")
    var iconUrl: String,
    @SerializedName("icon_width")
    var iconWidth: Int,
    @SerializedName("id")
    var id: String,
    @SerializedName("is_enabled")
    var isEnabled: Boolean,
    @SerializedName("is_new")
    var isNew: Boolean,
    @SerializedName("name")
    var name: String,
    @SerializedName("penny_donate")
    var pennyDonate: Int?,
    @SerializedName("penny_price")
    var pennyPrice: Int?,
    @SerializedName("resized_icons")
    var resizedIcons: List<ResizedIcon>,
    @SerializedName("resized_static_icons")
    var resizedStaticIcons: List<ResizedStaticIcon>,
    @SerializedName("start_date")
    var startDate: Any?,
    @SerializedName("static_icon_height")
    var staticIconHeight: Int,
    @SerializedName("static_icon_url")
    var staticIconUrl: String,
    @SerializedName("static_icon_width")
    var staticIconWidth: Int,
    @SerializedName("subreddit_coin_reward")
    var subredditCoinReward: Int,
    @SerializedName("subreddit_id")
    var subredditId: Any?,
    @SerializedName("tiers_by_required_awardings")
    var tiersByRequiredAwardings: Any?
)
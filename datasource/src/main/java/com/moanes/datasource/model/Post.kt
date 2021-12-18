package com.moanes.datasource.model


import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("all_awardings")
    var allAwardings: List<AllAwarding>,
    @SerializedName("allow_live_comments")
    var allowLiveComments: Boolean,
    @SerializedName("approved_at_utc")
    var approvedAtUtc: Any?,
    @SerializedName("approved_by")
    var approvedBy: Any?,
    @SerializedName("archived")
    var archived: Boolean,
    @SerializedName("author")
    var author: String,
    @SerializedName("author_flair_background_color")
    var authorFlairBackgroundColor: Any?,
    @SerializedName("author_flair_css_class")
    var authorFlairCssClass: Any?,
    @SerializedName("author_flair_richtext")
    var authorFlairRichtext: List<Any>,
    @SerializedName("author_flair_template_id")
    var authorFlairTemplateId: Any?,
    @SerializedName("author_flair_text")
    var authorFlairText: Any?,
    @SerializedName("author_flair_text_color")
    var authorFlairTextColor: Any?,
    @SerializedName("author_flair_type")
    var authorFlairType: String,
    @SerializedName("author_fullname")
    var authorFullname: String,
    @SerializedName("author_is_blocked")
    var authorIsBlocked: Boolean,
    @SerializedName("author_patreon_flair")
    var authorPatreonFlair: Boolean,
    @SerializedName("author_premium")
    var authorPremium: Boolean,
    @SerializedName("awarders")
    var awarders: List<Any>,
    @SerializedName("banned_at_utc")
    var bannedAtUtc: Any?,
    @SerializedName("banned_by")
    var bannedBy: Any?,
    @SerializedName("can_gild")
    var canGild: Boolean,
    @SerializedName("can_mod_post")
    var canModPost: Boolean,
    @SerializedName("category")
    var category: Any?,
    @SerializedName("clicked")
    var clicked: Boolean,
    @SerializedName("content_categories")
    var contentCategories: Any?,
    @SerializedName("contest_mode")
    var contestMode: Boolean,
    @SerializedName("created")
    var created: Double,
    @SerializedName("created_utc")
    var createdUtc: Double,
    @SerializedName("discussion_type")
    var discussionType: Any?,
    @SerializedName("distinguished")
    var distinguished: Any?,
    @SerializedName("domain")
    var domain: String,
    @SerializedName("downs")
    var downs: Int,
    @SerializedName("edited")
    var edited: Boolean,
    @SerializedName("gilded")
    var gilded: Int,
    @SerializedName("hidden")
    var hidden: Boolean,
    @SerializedName("hide_score")
    var hideScore: Boolean,
    @SerializedName("id")
    var id: String,
    @SerializedName("is_created_from_ads_ui")
    var isCreatedFromAdsUi: Boolean,
    @SerializedName("is_crosspostable")
    var isCrosspostable: Boolean,
    @SerializedName("is_meta")
    var isMeta: Boolean,
    @SerializedName("is_original_content")
    var isOriginalContent: Boolean,
    @SerializedName("is_reddit_media_domain")
    var isRedditMediaDomain: Boolean,
    @SerializedName("is_robot_indexable")
    var isRobotIndexable: Boolean,
    @SerializedName("is_self")
    var isSelf: Boolean,
    @SerializedName("is_video")
    var isVideo: Boolean,
    @SerializedName("likes")
    var likes: Any?,
    @SerializedName("link_flair_background_color")
    var linkFlairBackgroundColor: String,
    @SerializedName("link_flair_css_class")
    var linkFlairCssClass: Any?,
    @SerializedName("link_flair_richtext")
    var linkFlairRichtext: List<Any>,
    @SerializedName("link_flair_text")
    var linkFlairText: Any?,
    @SerializedName("link_flair_text_color")
    var linkFlairTextColor: String,
    @SerializedName("link_flair_type")
    var linkFlairType: String,
    @SerializedName("locked")
    var locked: Boolean,
    @SerializedName("media")
    var media: Media?,
    @SerializedName("media_only")
    var mediaOnly: Boolean,
    @SerializedName("mod_note")
    var modNote: Any?,
    @SerializedName("mod_reason_by")
    var modReasonBy: Any?,
    @SerializedName("mod_reason_title")
    var modReasonTitle: Any?,
    @SerializedName("mod_reports")
    var modReports: List<Any>,
    @SerializedName("name")
    var name: String,
    @SerializedName("no_follow")
    var noFollow: Boolean,
    @SerializedName("num_comments")
    var numComments: Int,
    @SerializedName("num_crossposts")
    var numCrossposts: Int,
    @SerializedName("num_reports")
    var numReports: Any?,
    @SerializedName("over_18")
    var over18: Boolean,
    @SerializedName("parent_whitelist_status")
    var parentWhitelistStatus: String,
    @SerializedName("permalink")
    var permalink: String,
    @SerializedName("pinned")
    var pinned: Boolean,
    @SerializedName("post_hint")
    var postHint: String,
    @SerializedName("preview")
    var preview: Preview,
    @SerializedName("pwls")
    var pwls: Int,
    @SerializedName("quarantine")
    var quarantine: Boolean,
    @SerializedName("removal_reason")
    var removalReason: Any?,
    @SerializedName("removed_by")
    var removedBy: Any?,
    @SerializedName("removed_by_category")
    var removedByCategory: Any?,
    @SerializedName("report_reasons")
    var reportReasons: Any?,
    @SerializedName("saved")
    var saved: Boolean,
    @SerializedName("score")
    var score: Int,
    @SerializedName("secure_media")
    var secureMedia: SecureMedia?,
    @SerializedName("selftext")
    var selftext: String,
    @SerializedName("selftext_html")
    var selftextHtml: Any?,
    @SerializedName("send_replies")
    var sendReplies: Boolean,
    @SerializedName("spoiler")
    var spoiler: Boolean,
    @SerializedName("stickied")
    var stickied: Boolean,
    @SerializedName("subreddit")
    var subreddit: String,
    @SerializedName("subreddit_id")
    var subredditId: String,
    @SerializedName("subreddit_name_prefixed")
    var subredditNamePrefixed: String,
    @SerializedName("subreddit_subscribers")
    var subredditSubscribers: Int,
    @SerializedName("subreddit_type")
    var subredditType: String,
    @SerializedName("suggested_sort")
    var suggestedSort: Any?,
    @SerializedName("thumbnail")
    var thumbnail: String,
    @SerializedName("thumbnail_height")
    var thumbnailHeight: Int,
    @SerializedName("thumbnail_width")
    var thumbnailWidth: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("top_awarded_type")
    var topAwardedType: Any?,
    @SerializedName("total_awards_received")
    var totalAwardsReceived: Int,
    @SerializedName("treatment_tags")
    var treatmentTags: List<String>,
    @SerializedName("ups")
    var ups: Int,
    @SerializedName("upvote_ratio")
    var upvoteRatio: Double,
    @SerializedName("url")
    var url: String,
    @SerializedName("url_overridden_by_dest")
    var urlOverriddenByDest: String,
    @SerializedName("user_reports")
    var userReports: List<Any>,
    @SerializedName("view_count")
    var viewCount: Any?,
    @SerializedName("visited")
    var visited: Boolean,
    @SerializedName("whitelist_status")
    var whitelistStatus: String,
    @SerializedName("wls")
    var wls: Int
)
package com.example.products.data.model

import com.google.gson.annotations.SerializedName

data class ProductModelResponse(
//    @SerializedName("status") var status: Status? = Status(),
//    @SerializedName("pageType") var pageType: String? = null,
    @SerializedName("plpResults") var plpResults: PlpResults? = PlpResults()
)

//data class Status(
//    @SerializedName("status") var status: String? = null,
//    @SerializedName("statusCode") var statusCode: Int? = null
//)

//data class Refinement(
//    @SerializedName("count") var count: Int? = null,
//    @SerializedName("label") var label: String? = null,
//    @SerializedName("refinementId") var refinementId: String? = null,
//    @SerializedName("selected") var selected: Boolean? = null,
//    @SerializedName("type") var type: String? = null,
//    @SerializedName("searchName") var searchName: String? = null
//)
//
//data class Ancester(
//    @SerializedName("label") var label: String? = null,
//    @SerializedName("categoryId") var categoryId: String? = null
//)
//
//data class Current(
//    @SerializedName("label") var label: String? = null,
//    @SerializedName("categoryId") var categoryId: String? = null
//)
//
//
data class PlpResults(
    @SerializedName("label") var label: String? = null,
//    @SerializedName("plpState") var plpState: PlpState? = PlpState(),
//    @SerializedName("sortOptions") var sortOptions: ArrayList<SortOptions> = arrayListOf(),
//    @SerializedName("refinementGroups") var refinementGroups: ArrayList<RefinementGroups> = arrayListOf(),
    @SerializedName("records") var records: ArrayList<Records> = arrayListOf(),
//    @SerializedName("navigation") var navigation: Navigation? = Navigation(),
//    @SerializedName("customUrlParam") var customUrlParam: CustomUrlParam? = CustomUrlParam()
)
//
//data class PlpState(
//    @SerializedName("categoryId") var categoryId: String? = null,
//    @SerializedName("currentSortOption") var currentSortOption: String? = null,
//    @SerializedName("currentFilters") var currentFilters: String? = null,
//    @SerializedName("firstRecNum") var firstRecNum: Int? = null,
//    @SerializedName("lastRecNum") var lastRecNum: Int? = null,
//    @SerializedName("recsPerPage") var recsPerPage: Int? = null,
//    @SerializedName("totalNumRecs") var totalNumRecs: Int? = null,
//    @SerializedName("originalSearchTerm") var originalSearchTerm: String? = null,
//    @SerializedName("plpSellerName") var plpSellerName: String? = null
//)

data class Records(
    @SerializedName("productId") var productId: String? = null,
    @SerializedName("skuRepositoryId") var skuRepositoryId: String? = null,
    @SerializedName("productDisplayName") var productDisplayName: String? = null,
    @SerializedName("productType") var productType: String? = null,
    @SerializedName("productRatingCount") var productRatingCount: Int? = null,
    @SerializedName("productAvgRating") var productAvgRating: Double? = null,
    @SerializedName("promotionalGiftMessage") var promotionalGiftMessage: String? = null,
    @SerializedName("listPrice") var listPrice: Double? = null,
    @SerializedName("minimumListPrice") var minimumListPrice: Double? = null,
    @SerializedName("maximumListPrice") var maximumListPrice: Double? = null,
    @SerializedName("promoPrice") var promoPrice: Double? = null,
    @SerializedName("minimumPromoPrice") var minimumPromoPrice: Double? = null,
    @SerializedName("maximumPromoPrice") var maximumPromoPrice: Double? = null,
    @SerializedName("isHybrid") var isHybrid: Boolean? = null,
    @SerializedName("isMarketPlace") var isMarketPlace: Boolean? = null,
    @SerializedName("isImportationProduct") var isImportationProduct: Boolean? = null,
    @SerializedName("brand") var brand: String? = null,
    @SerializedName("seller") var seller: String? = null,
    @SerializedName("category") var category: String? = null,
//    @SerializedName("dwPromotionInfo") var dwPromotionInfo: DwPromotionInfo? = DwPromotionInfo(),
    @SerializedName("isExpressFavoriteStore") var isExpressFavoriteStore: Boolean? = null,
    @SerializedName("isExpressNearByStore") var isExpressNearByStore: Boolean? = null,
    @SerializedName("smImage") var smImage: String? = null,
    @SerializedName("lgImage") var lgImage: String? = null,
    @SerializedName("xlImage") var xlImage: String? = null,
    @SerializedName("groupType") var groupType: String? = null,
//    @SerializedName("plpFlags") var plpFlags: ArrayList<String> = arrayListOf(),
    @SerializedName("variantsColor") var variantsColor: ArrayList<VariantsColor> = arrayListOf()
)

data class VariantsColor(
    @SerializedName("colorName") var colorName: String? = null,
    @SerializedName("colorHex") var colorHex: String? = null,
    @SerializedName("colorImageURL") var colorImageURL: String? = null,
    @SerializedName("colorMainURL") var colorMainURL: String? = null,
    @SerializedName("skuId") var skuId: String? = null
)

//
//data class SortOptions(
//    @SerializedName("sortBy") var sortBy: String? = null,
//    @SerializedName("label") var label: String? = null
//)
//
//data class Navigation(
//    @SerializedName("ancester") var ancester: ArrayList<Ancester> = arrayListOf(),
//    @SerializedName("current") var current: ArrayList<Current> = arrayListOf(),
//    @SerializedName("childs") var childs: ArrayList<String> = arrayListOf()
//)
//
//data class RefinementGroups(
//
//    @SerializedName("name") var name: String? = null,
//    @SerializedName("refinement") var refinement: ArrayList<Refinement> = arrayListOf(),
//    @SerializedName("multiSelect") var multiSelect: Boolean? = null,
//    @SerializedName("dimensionName") var dimensionName: String? = null
//
//)



//data class CustomUrlParam(val a: String = "")
//

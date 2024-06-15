package org.d3if3124.galerianjing.ui.model

data class Anjing(
    val id: Int,
    val user_email: String,
    val nama: String,
    val jenis: String,
    val image_id: String,
    val delete_hash: String,
    val created_at: String
)

data class AnjingCreate(
    val user_email: String,
    val nama: String,
    val jenis: String,
    val image_id: String,
    val delete_hash: String
)

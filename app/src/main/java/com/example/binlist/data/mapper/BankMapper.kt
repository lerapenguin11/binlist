package com.example.binlist.data.mapper

import com.example.binlist.core.database.entity.BankInfoEntity
import com.example.binlist.core.network.response.BankInfoResponse
import com.example.binlist.domain.model.bank.Bank
import com.example.binlist.domain.model.bank.BankDetails
import com.example.binlist.domain.model.bank.BankInfo
import com.example.binlist.domain.model.bank.Country
import com.example.binlist.domain.model.bank.Number

class BankMapper {

    fun bankInfoResponseToBankInfo(bankInfo: BankInfoResponse, bin: String): BankInfo {
        return BankInfo(
            bank = Bank(
                city = bankInfo.bank?.city,
                name = bankInfo.bank?.name,
                phone = bankInfo.bank?.phone,
                url = bankInfo.bank?.url
            ),
            brand = bankInfo.brand,
            country = Country(
                alpha2 = bankInfo.country?.alpha2,
                name = bankInfo.country?.name,
                numeric = bankInfo.country?.numeric,
                currency = bankInfo.country?.currency,
                latitude = bankInfo.country?.latitude,
                longitude = bankInfo.country?.longitude,
                emoji = bankInfo.country?.emoji
            ),
            number = Number(
                length = bankInfo.number?.length,
                luhn = bankInfo.number?.luhn
            ),
            prepaid = bankInfo.prepaid,
            scheme = bankInfo.scheme,
            type = bankInfo.type,
            bin = bin
        )
    }

    fun bankInfoEntityToBankInfo(bankInfo: BankInfoEntity): BankDetails {
        return BankDetails(
            scheme = bankInfo.scheme,
            type = bankInfo.type,
            length = bankInfo.length,
            lunh = bankInfo.lunh,
            country = bankInfo.country,
            phone = bankInfo.phone,
            bankName = bankInfo.bankName,
            city = bankInfo.city,
            latitude = bankInfo.latitude,
            longitude = bankInfo.longitude,
            url = bankInfo.url,
            brand = bankInfo.brand,
            prepaid = bankInfo.prepaid,
            bin = bankInfo.bin,
            id = bankInfo.id
        )
    }

    /*fun bankDetailsToBankInfoEntity(bankInfo: BankInfo): BankInfoEntity {
        return BankInfoEntity(
            scheme = bankInfo.scheme,
            type = bankInfo.type,
            length = bankInfo.length,
            lunh = bankInfo.lunh,
            country = bankInfo.country,
            phone = bankInfo.phone,
            bankName = bankInfo.bankName,
            city = bankInfo.city,
            latitude = bankInfo.latitude,
            longitude = bankInfo.longitude,
            url = bankInfo.url,
            brand = bankInfo.brand,
            prepaid = bankInfo.prepaid,
            bin = bankInfo.bin
        )
    }*/

    fun bankInfoToBankInfoEntity(bankInfo: BankInfo): BankInfoEntity {
        return BankInfoEntity(
            scheme = bankInfo.scheme,
            type = bankInfo.type,
            length = bankInfo.number?.length,
            lunh = bankInfo.number?.luhn,
            country = if (bankInfo.country?.emoji.isNullOrEmpty() && bankInfo.country?.name.isNullOrEmpty())
                null else
                "${bankInfo.country?.emoji} ${bankInfo.country?.name}",
            phone = bankInfo.bank?.phone,
            bankName = bankInfo.bank?.name,
            city = bankInfo.bank?.name,
            latitude = bankInfo.country?.latitude,
            longitude = bankInfo.country?.longitude,
            url = bankInfo.bank?.url,
            brand = bankInfo.brand,
            prepaid = bankInfo.prepaid,
            bin = bankInfo.bin
        )
    }
}
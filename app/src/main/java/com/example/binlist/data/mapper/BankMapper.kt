package com.example.binlist.data.mapper

import com.example.binlist.core.network.response.BankInfoResponse
import com.example.binlist.domain.model.bank.Bank
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
}
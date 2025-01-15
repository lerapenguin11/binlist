package com.example.binlist.presentation.mapper

import com.example.binlist.domain.model.bank.BankDetails
import com.example.binlist.domain.model.bank.BankInfo
import com.example.binlist.presentation.model.BankDetailsStable
import com.example.binlist.presentation.model.BankInfoStable

class BankInfoStableMapper() {

    fun bankInfoToBankInfoStable(bankInfo: BankInfo): BankInfoStable {
        return BankInfoStable(
            scheme = bankInfo.scheme,
            type = bankInfo.type,
            length = bankInfo.number?.length,
            lunh = bankInfo.number?.luhn,
            country = if (bankInfo.country?.emoji.isNullOrEmpty() && bankInfo.country?.name.isNullOrEmpty())
                null else
                    "${bankInfo.country?.emoji} ${bankInfo.country?.name}",
            phone = bankInfo.bank?.phone,
            bankName = bankInfo.bank?.name,
            city = bankInfo.bank?.city,
            latitude = bankInfo.country?.latitude,
            longitude = bankInfo.country?.longitude,
            url = bankInfo.bank?.url,
            brand = bankInfo.brand,
            prepaid = bankInfo.prepaid,
            bin = bankInfo.bin,
            id = CONST_ID
        )
    }

    fun bankDetailsToBankInfoStable(bankInfo: BankDetails): BankInfoStable {
        return BankInfoStable(
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
}

private const val CONST_ID = 0

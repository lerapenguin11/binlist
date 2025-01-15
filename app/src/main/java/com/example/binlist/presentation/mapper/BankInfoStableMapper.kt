package com.example.binlist.presentation.mapper

import com.example.binlist.domain.model.bank.BankInfo
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
            bin = bankInfo.bin
        )
    }
}

package com.asprog.imct.modules._common.data.mockData

import com.asprog.imct.modules.home.data.responses.AdsResponse
import com.asprog.imct.modules.home.data.responses.BannerResponse
import com.asprog.imct.modules.home.data.responses.HomeResponse
import com.asprog.imct.modules.home.data.responses.NewsResponse

object HomeDataMock {

    private val banner1 = BannerResponse(
        id = "1",
        image = "https://www.dvfu.ru/upload/resize_cache/iblock/03c/cxgpfgdrppo1z8wgh51lsoklkwl00e0j/1919_429_2/RMRD%20%D1%88%D0%B0%D0%BF%D0%BA%D0%B0%20%D1%81%D0%B0%D0%B9%D1%82%D0%B0.png",
        url = "http://rumeetup.ru/"
    )

    private val banner2 = BannerResponse(
        id = "2",
        image = "https://www.dvfu.ru/upload/resize_cache/iblock/ed7/rv6v1hresm2ayhtostlaafpj50xij9aj/1919_429_2/60jur.png",
        url = "https://www.dvfu.ru/journ60/"
    )

    private val banner3 = BannerResponse(
        id = "3",
        image = "https://www.dvfu.ru/upload/resize_cache/iblock/81f/1919_429_2/1(3).png",
        url = "https://www.dvfu.ru/science/"
    )

    private val ads1 = AdsResponse(
        id = "4",
        title = "Отключение горячей воды",
        description = "",
        time = "10"
    )
    private val ads2 = AdsResponse(
        id = "5",
        title = "Изменения в рассписании",
        description = "В понедельник поставлена пара для групп Б9118-миопд, проверьте рассписание в личном кабинете",
        time = "10"
    )
    private val ads3 = AdsResponse(
        id = "6",
        title = "RUSSKY DIGITAL",
        description = "Объявлены даты проведения мастер классов. Подробнее на сате http://rumeetup.ru/",
        time = "10"
    )
    private val ads4 = AdsResponse(
        id = "7",
        title = "Coursera",
        description = "Новые бесплатные курсы для студентов ДВФУ!",
        time = "10"
    )


    private val news1 = NewsResponse(
        id = "8",
        title = "В ДВФУ открыта регистрация на Осенний кубок чемпионата CASE-IN",
        description = textNews1,
        images = "https://www.dvfu.ru/upload/resize_cache/iblock/a3b/bm2ck34snijwrp2nf7yeonfyzdg3cui4/1919_429_2/casein09%2021.png",
        creator = "100"
    )

    private val news2 = NewsResponse(
        id = "9",
        title = "Тихоокеанский юридический форум 2021",
        description = textNews2,
        images = "https://www.dvfu.ru/upload/resize_cache/iblock/f20/cy76a7b5tiev5i3kijy5e8jp849jybq4/1919_429_2/%D1%82%D1%8E%D1%84.png",
        creator = "101"
    )

    private val news3 = NewsResponse(
        id = "10",
        title = "ДВФУ объявляет конкурс на лучшее научное издание",
        description = textNews3,
        images = "https://www.dvfu.ru/upload/resize_cache/iblock/867/azjq6p7a52enh941ka4gnsqx2ak5wryx/1919_429_2/%D0%BA%D0%BE%D0%BD%D0%BA%D1%83%D1%80%D1%81%D0%98%D0%B7%D0%B4.png",
        creator = "102"
    )

    private val news4 = NewsResponse(
        id = "11",
        title = "Продолжается набор в МВА Export to Asia",
        description = textNews4,
        images = "https://www.dvfu.ru/upload/resize_cache/iblock/796/ereifyzui3u09pcs2mu5p2a3o0gbgofm/1919_429_2/mba09.png",
        creator = "103"
    )


    private val listBanners = listOf(
        banner1,
        banner2,
        banner3
    )
    private val listAds = listOf(
        ads1,
        ads2,
        ads3,
        ads4
    )
    private val listNews = listOf(
        news1,
        news2,
        news3,
        news4
    )

    val data = HomeResponse(
        status = "success",
        banners = listBanners,
        ads = listAds,
        news = listNews
    )



}
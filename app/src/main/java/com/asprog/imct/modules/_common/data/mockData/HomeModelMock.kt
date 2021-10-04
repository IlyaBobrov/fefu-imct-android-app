package com.asprog.imct.modules._common.data.mockData

import com.asprog.imct.modules.home.data.models.HomeAdsModel
import com.asprog.imct.modules.home.data.models.HomeBannerModel
import com.asprog.imct.modules.home.data.models.HomeModel
import com.asprog.imct.modules.home.data.models.HomeNewsModel

object HomeModelMock {

    private val banner1 = HomeBannerModel(
        id = "3",
        ownerId = "300",
        image = "https://www.dvfu.ru/upload/resize_cache/iblock/03c/cxgpfgdrppo1z8wgh51lsoklkwl00e0j/1919_429_2/RMRD%20%D1%88%D0%B0%D0%BF%D0%BA%D0%B0%20%D1%81%D0%B0%D0%B9%D1%82%D0%B0.png",
        url = "http://rumeetup.ru/"
    )

    private val banner2 = HomeBannerModel(
        id = "2",
        ownerId = "300",
        image = "https://www.dvfu.ru/upload/resize_cache/iblock/ed7/rv6v1hresm2ayhtostlaafpj50xij9aj/1919_429_2/60jur.png",
        url = "https://www.dvfu.ru/journ60/"
    )

    private val banner3 = HomeBannerModel(
        id = "1",
        ownerId = "300",
        image = "https://www.dvfu.ru/upload/resize_cache/iblock/81f/1919_429_2/1(3).png",
        url = "https://www.dvfu.ru/science/"
    )

    private val ads1 = HomeAdsModel(
        id = "4",
        ownerId = "300",
        title = "Отключение горячей воды",
        description = "Горячая вод временно отключена на территории кампуса с 13:00 до 21:00. Приносим свои изменения за неудобства(",
        time = "10"
    )
    private val ads2 = HomeAdsModel(
        id = "5",
        ownerId = "300",
        title = "Изменения в рассписании",
        description = "В понедельник поставлена пара для групп Б9118-миопд, проверьте рассписание в личном кабинете",
        time = "10"
    )
    private val ads3 = HomeAdsModel(
        id = "6",
        ownerId = "300",
        title = "RUSSKY DIGITAL",
        description = "Объявлены даты проведения мастер классов. Подробнее на сате http://rumeetup.ru/",
        time = "10"
    )
    private val ads4 = HomeAdsModel(
        id = "7",
        ownerId = "300",
        title = "Coursera",
        description = "Новые бесплатные курсы для студентов ДВФУ!",
        time = "10"
    )


    private val news1 = HomeNewsModel(
        id = "8",
        ownerId = "300",
        title = "В ДВФУ открыта регистрация на Осенний кубок чемпионата CASE-IN",
        description = textNews1,
        images = "https://www.dvfu.ru/upload/resize_cache/iblock/a3b/bm2ck34snijwrp2nf7yeonfyzdg3cui4/1919_429_2/casein09%2021.png",
        creator = "100"
    )

    private val news2 = HomeNewsModel(
        id = "9",
        ownerId = "300",
        title = "Тихоокеанский юридический форум 2021",
        description = textNews2,
        images = "https://www.dvfu.ru/upload/resize_cache/iblock/f20/cy76a7b5tiev5i3kijy5e8jp849jybq4/1919_429_2/%D1%82%D1%8E%D1%84.png",
        creator = "101"
    )

    private val news3 = HomeNewsModel(
        id = "10",
        ownerId = "300",
        title = "ДВФУ объявляет конкурс на лучшее научное издание",
        description = textNews3,
        images = "https://www.dvfu.ru/upload/resize_cache/iblock/867/azjq6p7a52enh941ka4gnsqx2ak5wryx/1919_429_2/%D0%BA%D0%BE%D0%BD%D0%BA%D1%83%D1%80%D1%81%D0%98%D0%B7%D0%B4.png",
        creator = "102"
    )

    private val news4 = HomeNewsModel(
        id = "11",
        ownerId = "300",
        title = "Продолжается набор в МВА Export to Asia",
        description = textNews4,
        images = "https://www.dvfu.ru/upload/resize_cache/iblock/796/ereifyzui3u09pcs2mu5p2a3o0gbgofm/1919_429_2/mba09.png",
        creator = "103"
    )


    private val listBanners = listOf(
        banner3,
        banner2,
        banner1
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

    val data = HomeModel(
        id = "300",
        banners = listBanners,
        ads = listAds,
        news = listNews
    )

}
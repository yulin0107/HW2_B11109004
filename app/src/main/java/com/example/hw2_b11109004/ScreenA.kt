package com.example.hw2_b11109004

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScreenA(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "桃園景點清單", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
            SightseeingList(navController)
        }
    }
}

@Composable
fun SightseeingList(navController: NavController) {
    val sightseeingSpots = listOf(
        "Xpark 水族館",
        "綠光森林",
        "慈湖",
        "華泰名品城",
        "富田花園農場",
        "許厝港濕地",
        "馬祖新村眷村文創園區",
        "拉拉山自然保育區",
        "東眼山國家森林遊樂區",
        "李騰芳古宅",
        "竹圍漁港",
        "永安漁港",
        "小烏來天空步道",
        "大溪老街",
        "大溪老茶廠"
    )

    val imageNames = listOf(
        "p01",
        "p02",
        "p03",
        "p04",
        "p05",
        "p06",
        "p07",
        "p08",
        "p09",
        "p10",
        "p11",
        "p12",
        "p13",
        "p14",
        "p15",
    )

    val descriptions = listOf(
        "由台灣與日本橫濱八景島人氣水族館樂園耗時 5 年規劃打造，為台灣第一座新都會型的水生公園。360 度的沈浸式空間，透過空間結合科技，讓水族館體驗不再只是單純地透過玻璃觀賞生物，而能夠用五感來讓大家彷彿身歷其境。",
        "本休閒農場有滿地跑的小棉羊，可以跟羊咩咩近距離接觸，農場的歐式建築也讓人很有可以放鬆渡假的氛圍，春天有櫻花飛舞，四到五月有螢火蟲，深秋有落羽松，還可以看看雲海及彩霞，是個非常愜意放鬆的自然系景點。",
        "分為前慈湖與後慈湖，前慈湖有「慈湖陵寢」先總統蔣介石先生即長眠於此，因對其母親的思念之情，將這裡命名為慈湖。後慈湖是新月形的，為桃園農田水利會灌溉埤塘，另外園區中設有慈湖遊客中心、慈湖雕塑紀念公園、兩蔣文化園區，也有慈湖步道、百吉林蔭步道保存著原始的生態很適合一家大小一同郊遊，高處也可以欣賞大溪的全景。",
        "有著上百家精品品牌進駐的大型 Outlet 商場，在這裡你可以享受超值優惠折扣盡情購物，包括服飾、旅行與生活用品等都可以一次購足，逛累了還能享受商場內的各大主題餐廳美食，編輯每次來到這裡可是得逛上一整個下午才捨得回家！",
        "位於桃園大溪的「富田花園農場」以北海道富田農場為設計藍圖，打造充滿歐風氣息的秘境花園，不僅有歐洲鄉間建築讓你盡情打卡拍照，還能與草泥馬、山羊、馬、麝香小豬等可愛動物近距離互動。",
        "經過竹圍漁港再往南行到老街溪及雙溪口溪匯流處，每年的十月到隔年五月都可以看到不同的候鳥在此過境，像是黑面琵鷺、唐白鷺、黑嘴鷗、小燕鷗等，設有步道及腳踏車道，在海岸邊還可以看到遠處轉動的風車，也是一個潮間帶生態區。",
        "是當時該地區的第一個眷村，後來擴大到了二百多戶，在居民漸漸搬遷之後村落發展成了文創園區，成為保留當地眷村文化特色的景點，現在有許多藝術家進駐，並定期舉辦文創市集。",
        "位於桃園市復興區和新北市烏來區交界處，保護區內有檜木巨木群、山毛櫸、扁柏等植物，也有許多野生動物，目前保護區沒有完全開放。",
        "早期是北部的林場，經過了復育現在可以看到滿山的人山造林，因為從石門水庫的方向眺望其形狀很像眼睛又朝向東方因為有了東眼山的名稱。此處也是北部極佳的賞鳥地點，有機會看到灰喉山椒鳥、五色鳥、台灣畫眉等等的鳥類，園區內也有一些特殊的地質景觀及豐富的動植物。",
        "李騰芳古宅是國定二級古蹟，又稱「李金興古厝」是同治年間舉人李騰芳的私宅，是典型的紹安客家形式建築，門廳與正廳的木雕十分精美，又由於李騰芳喜歡繪畫，室內也有許多書畫裝飾。",
        "「竹圍漁港」是一個觀光漁港，有新鮮的海鮮現場現點餐廳代客料理，也有美麗的風景，北邊的入口有一座彩虹橋是觀看漁船入港的好位置，因為距離桃園機場只有三公里還可以看飛機起降，黃昏及入夜後的景色也十分美麗。",
        "位於社子溪出海口，本來的名稱叫做崁頭屋港，有一以座龍蝦外型為設計概念的觀光漁市，是全台唯一的客家漁港，港邊的一座跨海大橋在傍晚五點會點亮燈光，很適合看夕陽、夜景，設有觀景平臺可以觀看漁船入港，周邊還規劃有綠色隧道可以騎腳踏車，吃完海鮮剛好可以消耗一下熱量！",
        "小烏來瀑布有三層，以中段的「斷層懸谷型」最為壯觀。另外小烏來的天空步道也是風景區內熱門的景點，遊客可以站在透明玻璃平台上欣賞瀑布磅礡的氣勢，不過天空步道記得要在入園前先網路預約喔！",
        "主要是和平路、中山路、中央路這三條歷史街區組成，保存了台灣早期的外觀與牌樓立面，因早期大溪曾是重要的內陸港口，從淡水、大稻埕、艋舺的貨船可抵達大溪，造就了當地一時的繁榮，也是桃園地區開發最早的區域。",
        "建築物融合英倫美學與日式美學的綠建築，已經在大溪有近百年的歷史，一踏入茶廠內就可以感受的優雅的茶文化，二樓的一整排復古藍色窗戶，來到大溪千萬不要錯過這個可以享受茶點的高質感空間！"
    )
    LazyColumn {
        items(sightseeingSpots.zip(imageNames).zip(descriptions)) { (spotWithImage, description) ->
            val (sight, imageName) = spotWithImage
            SightseeingListItem(sight, imageName, description, navController)
        }
    }
}

@Composable
fun SightseeingListItem(
    sight: String,
    imageName: String,
    description: String,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, Color.LightGray)
        ) {
                Text(
                    text = sight,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            navController.navigate("screenB/$sight/$imageName/$description")
                        }
                )
            }
        }
    }


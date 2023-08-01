package com.example.jetpackcomoseui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomoseui.ui.theme.AquaBlue
import com.example.jetpackcomoseui.ui.theme.BlueViolet3
import com.example.jetpackcomoseui.ui.theme.BottomMenuContent
import com.example.jetpackcomoseui.ui.theme.ButtonBlue
import com.example.jetpackcomoseui.ui.theme.DeepBlue
import com.example.jetpackcomoseui.ui.theme.LightGrey
import com.example.jetpackcomoseui.ui.theme.LightPurple
import com.example.jetpackcomoseui.ui.theme.TextWhite

val orderList = listOf(
    OrderDetail(
        detailIconId = R.drawable.ic_more_detail,
        statusIconId = R.drawable.ic_on_way,
        title = "Smartphone",
        trackingNo = "123456789",
        status = "On Way",
        from = "New York",
        to = "Los Angeles",
        price = 99.99
    ),
    OrderDetail(
        detailIconId = R.drawable.ic_more_detail,
        statusIconId = R.drawable.ic_deleiverd,
        title = "Laptop",
        trackingNo = "987654321",
        status = "Delivered",
        from = "San Francisco",
        to = "Seattle",
        price = 149.99
    ),
    OrderDetail(
        detailIconId = R.drawable.ic_more_detail,
        statusIconId = R.drawable.ic_warehouse,
        title = "Headphones",
        trackingNo = "246813579",
        status = "Processing",
        from = "Chicago",
        to = "Houston",
        price = 79.99
    ),
    OrderDetail(
        detailIconId = R.drawable.ic_more_detail,
        statusIconId = R.drawable.ic_on_way,
        title = "Sneakers",
        trackingNo = "135792468",
        status = "On Way",
        from = "Miami",
        to = "Orlando",
        price = 49.99
    ),
    OrderDetail(
        detailIconId = R.drawable.ic_more_detail,
        statusIconId = R.drawable.ic_deleiverd,
        title = "Hoodie",
        trackingNo = "369852147",
        status = "Delivered",
        from = "Dallas",
        to = "Austin",
        price = 89.99
    ),
    OrderDetail(
        detailIconId = R.drawable.ic_more_detail,
        statusIconId = R.drawable.ic_warehouse,
        title = "Pair of Jeans",
        trackingNo = "785412369",
        status = "Cancelled",
        from = "Boston",
        to = "Washington D.C.",
        price = 199.99
    )
)

val menuItems = listOf(
    BottomMenuContent(iconId = R.drawable.ic_email),
    BottomMenuContent(iconId = R.drawable.ic_location),
    BottomMenuContent(iconId = R.drawable.ic_home),
    BottomMenuContent(iconId = R.drawable.ic_calculator),
)

val status = listOf("Delivering", "Received", "All", "Canceled")


@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {

        Column {
            ProfileRow(modifier = Modifier)
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .padding(start = 12.dp)
            ) {
                Text(text = "Track Your Shipment", style = Typography.bodyLarge)
            }
            SearchRow(modifier = Modifier)
            CardView(modifier = Modifier, status = status, orders = orderList)
            BottomMenu(items = menuItems)

        }
    }
}

@Composable
fun ProfileRow(modifier: Modifier) {
    var isMenuSelected by remember { mutableStateOf(false) }
    var isMoonSelected by remember { mutableStateOf(false) }
    var isNotificationsSelected by remember { mutableStateOf(false) }
    var isPersonSelected by remember { mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth(.35f)
                .padding(4.dp)
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(LightPurple)
                    .padding(6.dp)
                    .size(36.dp)
            ) {
                IconButton(
                    onClick = {
                        isMenuSelected = true
                        isPersonSelected = false
                        isNotificationsSelected = false
                        isMoonSelected = false
                    },
                    modifier = Modifier.size(72.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_menu_24),
                        contentDescription = null,
                        tint = if (isMenuSelected) ButtonBlue else AquaBlue,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize()
                    )
                }
            }


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(LightPurple)
                    .padding(6.dp)
                    .size(36.dp)
            ) {
                IconButton(
                    onClick = {
                        isMoonSelected = true
                        isPersonSelected = false
                        isNotificationsSelected = false
                        isMenuSelected = false
                    },
                    modifier = Modifier.size(72.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_moon),
                        contentDescription = null,
                        tint = if (isMoonSelected) ButtonBlue else AquaBlue,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize()
                    )
                }
            }

        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth(.55f)
                .padding(4.dp)
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(LightPurple)
                    .padding(6.dp)
                    .size(36.dp)
            ) {
                IconButton(
                    onClick = {
                        isPersonSelected = false
                        isNotificationsSelected = true
                        isMenuSelected = false
                        isMoonSelected = false
                    },
                    modifier = Modifier.size(72.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_notifications_24),
                        contentDescription = null,
                        tint = if (isNotificationsSelected) ButtonBlue else AquaBlue,
                        modifier = modifier
                            .padding(8.dp)
                            .fillMaxSize()

                    )
                }
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(LightPurple)
                    .padding(6.dp)
                    .size(36.dp)
            ) {
                IconButton(
                    onClick = {
                        isPersonSelected = true
                        isNotificationsSelected = false
                        isMenuSelected = false
                        isMoonSelected = false
                    },
                    modifier = Modifier.size(72.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = null,
                        tint = if (isPersonSelected) ButtonBlue else AquaBlue,
                        modifier = modifier
                            .padding(8.dp)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchRow(modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.15f)
            .padding(15.dp)
    ) {
        var editText by remember {
            mutableStateOf("")
        }

        Row(modifier = modifier.fillMaxWidth(0.75f)) {
            OutlinedTextField(value = editText, onValueChange = { text ->
                editText = text
            })
        }


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(LightPurple)
                .padding(6.dp)
                .size(36.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = AquaBlue,
                modifier = modifier
                    .size(28.dp)
                    .padding(4.dp)
            )
        }
    }
}

@Composable
fun CardView(modifier: Modifier, status: List<String>, orders: List<OrderDetail>) {
    Column(
        modifier = modifier
            .fillMaxHeight(.86f)
            .padding(start = 12.dp, top = 6.dp)
            .background(ButtonBlue)
    ) {
        LazyRow {
            items(status.size) {
                Text(
                    text = status[it],
                    style = Typography.bodyMedium,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                )
            }
        }

        LazyColumn(modifier = modifier.padding(8.dp)) {
            items(orders.size) { order ->
                OrderCard(order = orders[order])
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun OrderCard(order: OrderDetail) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(LightPurple)
                        .padding(6.dp)
                        .size(36.dp)
                ) {
                    Icon(
                        painter = painterResource(id = order.statusIconId),
                        contentDescription = "Status Icon",
                        tint = DeepBlue,
                        modifier = Modifier.size(32.dp)
                    )
                }
                Column {
                    Text(
                        text = order.title,
                        style = Typography.bodyLarge,
                        textAlign = TextAlign.Start,
                    )

                    Text(
                        text = order.trackingNo,
                        style = Typography.bodySmall,
                        textAlign = TextAlign.Start
                    )
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(LightPurple)
                        .padding(6.dp)
                        .size(36.dp)
                ) {
                    Icon(
                        painter = painterResource(id = order.detailIconId),
                        contentDescription = "Detail Icon",
                        tint = DeepBlue,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.fillMaxWidth(0.5f)
                    .padding(start = 12.dp)) {
                    Text(
                        text = "From:",
                        style = Typography.bodySmall,
                        textAlign = TextAlign.Start,
                        color = Color.Gray
                    )
                    Text(
                        text = order.from,
                        style = Typography.labelMedium,
                        textAlign = TextAlign.Start
                    )
                }

                Column(modifier = Modifier.fillMaxWidth(0.55f)
                    .padding(end = 8.dp)) {
                    Text(
                        text = "Status:",
                        style = Typography.bodySmall,
                        textAlign = TextAlign.Start,
                        color = Color.Gray
                    )

                    Text(
                        text = order.status,
                        style = Typography.labelMedium,
                        textAlign = TextAlign.Start
                    )
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.fillMaxWidth(0.5f)
                    .padding(start = 12.dp)) {
                    Text(
                        text = "To:",
                        style = Typography.bodySmall,
                        textAlign = TextAlign.Start,
                        color = Color.Gray
                    )
                    Text(
                        text = order.to,
                        style = Typography.labelMedium,
                        textAlign = TextAlign.Start
                    )
                }

                Column(modifier = Modifier.fillMaxWidth(0.55f)
                    .padding(end = 8.dp)) {
                    Text(
                        text = "Price:",
                        style = Typography.bodySmall,
                        textAlign = TextAlign.Start,
                        color = Color.Gray
                    )

                    Text(
                        text = "$${order.price}",
                        style = Typography.labelMedium,
                        textAlign = TextAlign.Start
                    )
                }

            }
        }
    }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(LightGrey)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = null,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}


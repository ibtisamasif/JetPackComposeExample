package com.example.jetpackcomoseui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomoseui.ui.theme.BackgroundColor
import com.example.jetpackcomoseui.ui.theme.Black
import com.example.jetpackcomoseui.ui.theme.ColorDefault
import com.example.jetpackcomoseui.ui.theme.White
import com.example.jetpackcomoseui.ui.theme.greenTransparent
import com.example.jetpackcomoseui.ui.theme.hint_text_color
import com.example.jetpackcomoseui.ui.theme.lightBlack
import com.example.jetpackcomoseui.ui.theme.light_green
import com.example.jetpackcomoseui.ui.theme.md_dark_green
import com.example.jetpackcomoseui.ui.theme.md_red_warning
import com.example.jetpackcomoseui.ui.theme.mediumBlack
import com.example.jetpackcomoseui.ui.theme.skyBlue
import com.example.jetpackcomoseui.ui.theme.ultralightGreyBlue
import com.example.jetpackcomoseui.ui.theme.ultralight_blue
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

val fonts = FontFamily(
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_black, FontWeight.Black),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_extra_bold, FontWeight.ExtraBold),
    Font(R.font.inter_extra_light, FontWeight.ExtraLight),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_semi_bold, FontWeight.SemiBold),
    Font(R.font.inter_thin, FontWeight.Thin),
)

val dropDownList = listOf("1", "2", "3", "4", "5")


@Composable
fun FullScreen() {
    LazyColumn(
        modifier = Modifier
            .background(BackgroundColor)
            .fillMaxSize()
    ) {
        item {
            saveButton()
            Spacer(modifier = Modifier.height(4.dp))
            plannedUnplanned()
            Spacer(modifier = Modifier.height(4.dp))
            WorkOrderName()
            Spacer(modifier = Modifier.height(4.dp))
            Status()
            Spacer(modifier = Modifier.height(4.dp))
            Assets()
            Spacer(modifier = Modifier.height(4.dp))
            Employee()
            Spacer(modifier = Modifier.height(4.dp))
            Teams()
            Spacer(modifier = Modifier.height(4.dp))
            DateAndTimeRow()
            Spacer(modifier = Modifier.height(4.dp))
            EstimatedTime()
            Spacer(modifier = Modifier.height(4.dp))
            Category()
            Spacer(modifier = Modifier.height(4.dp))
            Description()
            Spacer(modifier = Modifier.height(4.dp))
            PriorityRow()
            Spacer(modifier = Modifier.height(4.dp))
            Tags()
            Spacer(modifier = Modifier.height(4.dp))
            Checklist()
            Spacer(modifier = Modifier.height(8.dp))
            SpareParts()
            Spacer(modifier = Modifier.height(8.dp))
            Attachments()
            Spacer(modifier = Modifier.height(4.dp))
            DynamicView(listOf("122", "123", "321", "123"))
            Spacer(modifier = Modifier.height(4.dp))
            ShowMore()

        }
    }
}

@Composable
fun saveButton() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(.7f)
                .padding(4.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null,
                tint = ColorDefault,
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(24.dp)
                    .clickable {}
            )

            Text(
                text = "Edit Work Order",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp
                ),
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(end = 4.dp)
            )
        }

        Text(
            text = "Save",
            style = TextStyle(
                color = skyBlue,
                fontFamily = fonts,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            ),
            textAlign = TextAlign.Start,
            modifier = Modifier.clickable {}
        )
    }
}

@Composable
fun plannedUnplanned() {
    var selectedOption by remember { mutableStateOf("unplanned") }

    Surface(color = BackgroundColor) {
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(24.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.45f)
                    .height(36.dp)
                    .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
                    .align(Alignment.CenterVertically)
                    .toggleable(
                        value = selectedOption == "unplanned",
                        onValueChange = {
                            selectedOption = if (it) "unplanned" else "planned"
                        }
                    )
                    .background(if (selectedOption == "unplanned") light_green else ultralight_blue),
            ) {
                Text(
                    text = "UNPLANNED",
                    style = TextStyle(
                        color = md_dark_green,
                        fontFamily = fonts,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                        .align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.width(1.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(36.dp)
                    .align(Alignment.CenterVertically)
                    .clip(RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp))
                    .toggleable(
                        value = selectedOption == "planned",
                        onValueChange = {
                            selectedOption = if (it) "planned" else "unplanned"
                        }
                    )
                    .background(if (selectedOption == "planned") light_green else ultralight_blue),
            ) {
                Text(
                    text = "PLANNED",
                    style = TextStyle(
                        color = md_dark_green,
                        fontFamily = fonts,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun WorkOrderName() {
    var editText by remember { mutableStateOf("") }
    var hint = "Enter Work Order name..."
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {

        Box(
            modifier = Modifier
                .align(Alignment.Bottom)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_workorder_small),
                contentDescription = "Name",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 8.dp)

            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(
                text = "Name*",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
            )


                BasicTextField(
                    value = editText,
                    onValueChange = { text -> editText = text },
                    textStyle = TextStyle(
                        fontFamily = fonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Justify
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BackgroundColor)
                        .height(IntrinsicSize.Min),
                    maxLines = 1,
                    decorationBox = { innerTextField ->
                        if (editText.isEmpty()) {
                            Text(
                                text = hint,
                                fontSize = 16.sp,
                                fontFamily = fonts,
                                fontWeight = FontWeight.Medium,
                                color = hint_text_color,
                                modifier = Modifier.wrapContentHeight(Alignment.Bottom)
                            )
                        }
                        innerTextField()
                    }
                )

            Divider(color = ColorDefault, thickness = 1.dp)
        }
    }
}

@Composable
fun Status() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_category_small),
            contentDescription = "Status",
            modifier = Modifier
                .size(32.dp)
                .wrapContentHeight(Alignment.Bottom)
                .padding(start = 8.dp )
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp)
        ) {
            Text(
                text = "Status",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )
            dropDownMenuList(items = dropDownList)

            Divider(color = ColorDefault, thickness = 1.dp)
        }
    }
}

@Composable
fun Assets() {
    var selectedAsset by remember { mutableStateOf("") }
    val assestHint = "Select Asset"

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {

        Box(
            modifier = Modifier
                .align(Alignment.Bottom)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_asset_small),
                contentDescription = "Assets",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 6.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.fillMaxWidth(0.7f).padding(start = 4.dp)) {
            Text(
                text = "Asset*",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )

            dropDownIcon(text = selectedAsset, hint = assestHint)

            Divider(
                color = ColorDefault,
                thickness = 1.dp,
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_qr_20),
            contentDescription = "Scan",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp, top = 6.dp)
                .clickable {}
        )
    }
}

@Composable
fun Employee() {
    var employee by remember { mutableStateOf("") }
    val employeeHint = "Select responsible employee"

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Bottom)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_assignee_small),
                contentDescription = "Employee",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column( modifier = Modifier.padding(start = 8.dp)) {
            Text(
                text = "Employee*",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )

            dropDownIcon(text = employee, hint = employeeHint)

            Divider(
                color = ColorDefault,
                thickness = 1.dp,

            )
        }
    }
}

@Composable
fun Teams() {
    var team by remember { mutableStateOf("") }
    val teamsHint = "Select responsible team"

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Bottom)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_team),
                contentDescription = "Teams",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 12.dp)

            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column( modifier = Modifier.padding(start = 6.dp)) {
            Text(
                text = "Team*",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )

            dropDownIcon(text = team, hint = teamsHint)

            Divider(
                color = ColorDefault,
                thickness = 1.dp
            )
        }
    }
}

@Composable
fun DateAndTimeRow() {

    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }

    val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    val currentDateTime = Calendar.getInstance()

    date = dateFormat.format(currentDateTime.time)
    time = timeFormat.format(currentDateTime.time)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Bottom)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_icon_calendar_20),
                contentDescription = "Due Date",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 12.dp, bottom = 10.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth(.45f)
                .padding(8.dp)
        ) {
            Text(
                text = "Due date*",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = date,
                    style = TextStyle(
                        color = Black,
                        fontFamily = fonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )

                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_dropdown),
                    tint = ColorDefault,
                    contentDescription = "drop down",
                    modifier = Modifier
                        .size(32.dp)
                        .padding(start = 4.dp)
                )

            }

            Divider(color = ColorDefault, thickness = 1.dp)
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth(.8f)
                .padding(8.dp)
        ) {
            Text(
                text = "Due time*",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = time,
                    style = TextStyle(
                        color = Black,
                        fontFamily = fonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .padding(start = 4.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_dropdown),
                    tint = ColorDefault,
                    contentDescription = "drop down",
                    modifier = Modifier
                        .size(32.dp)
                        .padding(start = 4.dp)
                )

            }

            Divider(color = ColorDefault, thickness = 1.dp)
        }
    }
}

@Composable
fun EstimatedTime() {
    var estimated by remember { mutableStateOf("") }
    var hint = "Estimated time in hours..."

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Bottom)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_workorder_small),
                contentDescription = "Time",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                text = "Estimated Time",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )


                BasicTextField(
                    value = estimated,
                    onValueChange = { text -> estimated = text.replace(Regex("[^0-9]"), "") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BackgroundColor)
                        .height(intrinsicSize = IntrinsicSize.Min),
                    maxLines = 1,
                    decorationBox = { innerTextField ->
                        if (estimated.isEmpty()) {
                            Text(
                                text = hint,
                                fontSize = 14.sp,
                                fontFamily = fonts,
                                fontWeight = FontWeight.Normal,
                                color = hint_text_color,
                                modifier = Modifier.wrapContentHeight(Alignment.Bottom)
                            )
                        }
                        innerTextField()
                    }
                )

            Divider(color = ColorDefault, thickness = 1.dp)
        }
    }
}

@Composable
fun Category() {
    var category by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Bottom)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_category_small),
                contentDescription = "Category",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 8.dp)
            )
        }


        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                text = "Category",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )

            dropDownMenuList(items = dropDownList)
            Divider(
                color = ColorDefault,
                thickness = 1.dp,
            )
        }
    }
}

@Composable
fun Description() {
    var description by remember { mutableStateOf("") }
    var hint = "Enter a brief description"

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Bottom)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_text_small),
                contentDescription = "Description",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                text = "Description",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                BasicTextField(
                    value = description,
                    onValueChange = { text -> description = text },
                    textStyle = TextStyle(
                        fontFamily = fonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .background(BackgroundColor)
                        .wrapContentHeight(Alignment.Bottom)
                        .height(IntrinsicSize.Min),
                    maxLines = 3,
                    decorationBox = { innerTextField ->
                        if (description.isEmpty()) {
                            Text(
                                text = hint,
                                fontSize = 14.sp,
                                fontFamily = fonts,
                                fontWeight = FontWeight.Normal,
                                color = hint_text_color,
                                modifier = Modifier.wrapContentHeight(Alignment.Bottom)
                            )
                        }
                        innerTextField()
                    }
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_mic_blue_24dp),
                    tint = skyBlue,
                    contentDescription = "ivSpeech",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(24.dp)
                        .clickable { }
                )
            }

            Divider(
                color = ColorDefault,
                thickness = 1.dp
            )
        }
    }
}

@Composable
fun PriorityRow() {
    var isSelected0 by remember { mutableStateOf(false) }
    var isSelected1 by remember { mutableStateOf(false) }
    var isSelected2 by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Bottom)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_priority_small),
                contentDescription = "Priority",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 8.dp, bottom = 2.dp)
            )
        }

        Column {
            Text(
                text = "Criticality",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
            )

            Row(modifier = Modifier.fillMaxWidth(.9f)) {
                Button(
                    onClick = {
                        isSelected0 = !isSelected0; isSelected1 = false; isSelected2 = false
                    },
                    modifier = Modifier
                        .height(40.dp)
                        .padding(1.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected0) light_green else ultralight_blue,
                        contentColor = ColorDefault
                    ),
                    shape = RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp),
                ) {
                    Text(
                        text = "0",
                        style = TextStyle(
                            color = md_dark_green,
                            fontFamily = fonts,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                }

                Button(
                    onClick = {
                        isSelected1 = !isSelected1; isSelected0 = false; isSelected2 = false
                    },
                    modifier = Modifier
                        .height(40.dp)
                        .padding(1.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected1) light_green else ultralight_blue,
                        contentColor = ColorDefault
                    ),
                    shape = RoundedCornerShape(0.dp),
                ) {
                    Text(
                        text = "!",
                        style = TextStyle(
                            color = md_dark_green,
                            fontFamily = fonts,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                }

                Button(
                    onClick = {
                        isSelected2 = !isSelected2; isSelected0 = false; isSelected1 = false
                    },
                    modifier = Modifier
                        .height(40.dp)
                        .padding(1.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected2) md_red_warning else ultralight_blue,
                        contentColor = ColorDefault
                    ),
                    shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp),
                ) {
                    Text(
                        text = "!!",
                        style = TextStyle(
                            color = md_dark_green,
                            fontFamily = fonts,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                }
            }
        }
    }
}

@Composable
fun Tags() {
    var tags by remember { mutableStateOf("") }
    val tagstHint = "Select one or more tags"

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Bottom)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_tag_small),
                contentDescription = "Tags",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                text = "Tags",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )

            dropDownIcon(text = tags, hint = tagstHint)

            Divider(
                color = ColorDefault,
                thickness = 1.dp
            )
        }
    }
}

@Composable
fun Checklist() {
    var checklist by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Bottom)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_workorder_small),
                contentDescription = "checklist",
                modifier = Modifier
                    .size(32.dp)

                    .padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                text = "Checklist:",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
            )

            dropDownMenuList(items = dropDownList)
            Divider(color = ColorDefault, thickness = 1.dp)
        }
    }
}

@Composable
fun SpareParts() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .fillMaxHeight(.1f)
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_part_small),
            contentDescription = "Spare Parts",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp)
        )

        Text(
            text = "Spare Parts",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontFamily = fonts,
                fontSize = 16.sp,
                color = md_dark_green
            ),
            modifier = Modifier.padding(20.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.ic_stat_add_blue),
            contentDescription = "Add Spare Parts",
            modifier = Modifier.size(24.dp)
        )
    }

    SparePartsList()
}

@Composable
fun SparePartsList() {
    val sparePartsList = remember { listOf("kg", "g") }
    Column(
        modifier = Modifier
            .fillMaxWidth(.95f)
            .padding(top = 8.dp, start = 48.dp, end = 12.dp)
    ) {
        sparePartsList.forEach { s ->
            SparePartRow(spareParts = s)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun SparePartRow(spareParts: String = "") {
    val text = "Abcdefg"
    var editText by remember { mutableStateOf("1") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .height(70.dp)
            .border(1.dp, ultralightGreyBlue, RoundedCornerShape(10.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            Text(
                text = text,
                fontSize = 18.sp,
                fontFamily = fonts,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = md_dark_green,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_quantity),
                    tint = ColorDefault,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                )

                Text(
                    text = spareParts,
                    fontSize = 12.sp,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = md_dark_green,
                    modifier = Modifier.padding(bottom = 4.dp, start = 8.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(.22f)
                .fillMaxHeight(.82f)
                .border(1.dp, ultralightGreyBlue, RoundedCornerShape(6.dp))
                .padding(end = 4.dp),
        ) {
            BasicTextField(
                value = editText,
                onValueChange = { text -> editText = text },
                maxLines = 1,
                modifier = Modifier.fillMaxSize().wrapContentWidth(Alignment.CenterHorizontally).wrapContentHeight(Alignment.CenterVertically),
                textStyle = TextStyle(
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                ),

            )

        }

        Icon(
            painter = painterResource(R.drawable.icon_delete_20),
            tint = ColorDefault,
            contentDescription = null,
            modifier = Modifier
                .weight(.3f)
                .size(35.dp)
                .padding(8.dp)
                .clickable {},
        )
    }
}

@Composable
fun Attachments() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_attachment_small),
            contentDescription = "Documents",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp)
        )

        Text(
            text = "Attachments",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontFamily = fonts,
                fontSize = 16.sp,
                color = md_dark_green
            ),
            modifier = Modifier.padding(20.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.ic_stat_add_blue),
            contentDescription = "Add Document",
            modifier = Modifier.size(24.dp)
        )
    }

    DocumentList()
}

@Composable
fun DocumentList() {
    val documentList =
        remember { listOf("akdsndksdnskdnskdsknsdnskdsnkskdnsdnskdsnksnksdks", "b", "c") }

    Column(
        modifier = Modifier
            .fillMaxWidth(.95f)
            .padding(top = 8.dp, start = 48.dp, end = 12.dp)
    ) {
        documentList.forEach { document ->
            DocumentRow(item = document)
        }
    }
}

@Composable
fun DocumentRow(item: String) {
    val itemDate = "123"
    val category = "pta nhi"
    var isImageLoaded by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(containerColor = White),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .border(0.5.dp, greenTransparent, RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .background(White),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(height = 56.dp, width = 58.dp)
                    .border(0.5.dp, greenTransparent, RoundedCornerShape(10.dp))
            ) {
                Crossfade(targetState = isImageLoaded) { targetState ->
                    if (targetState) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_assignee_small),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        CircularProgressIndicator(
                            color = skyBlue,
                            strokeWidth = Dp(value = 4F),
                            modifier = Modifier
                                .fillMaxSize(.8f)
                                .align(Alignment.Center)
                        )
                    }
                }
                if (!isImageLoaded) {
                    LaunchedEffect(true) {
                        delay(2000)
                        isImageLoaded = true
                    }
                }
            }


            Column(
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .height(IntrinsicSize.Max)
                    .weight(1f)
            ) {
                Text(
                    text = item,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, start = 12.dp),
                    maxLines = 1,
                    style = TextStyle(
                        color = md_dark_green,
                        fontFamily = fonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    ),
                    overflow = TextOverflow.Ellipsis,
                )

                Text(
                    text = "$itemDate - $category",
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 8.dp, start = 12.dp, bottom = 4.dp),
                    style = TextStyle(
                        color = md_dark_green,
                        fontFamily = fonts,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp
                    ),
                )
            }

            Icon(
                painter = painterResource(R.drawable.ic_more_detail),
                // apply condition when api response failed
                // painterResource(R.drawable.ic_cross_small),
                tint = ColorDefault,
                contentDescription = null,
                modifier = Modifier
                    .size(28.dp)
                    .padding(end = 4.dp)
                    .clickable {}
            )

        }
    }
}

@Composable
fun DynamicView(customField: List<String>) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        customField.forEach { item ->
            CustomFields(item)
            Spacer(modifier = Modifier.height(16.dp))
        }

    }
}

@Composable
fun CustomFields(customField: String) {
    var fieldValue by remember { mutableStateOf("") }
    var label by remember {
        mutableStateOf("abcd")
    }
    var hint = "Numeric"

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Bottom)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_icon_edit),
                contentDescription = "Custom Field",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 8.dp, bottom = 6.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                text = label,
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            )

            if (customField != "123") {
                BasicTextField(
                    value = fieldValue,
                    onValueChange = { text -> fieldValue = text },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BackgroundColor)
                        .height(IntrinsicSize.Min),
                    maxLines = 1,
                    decorationBox = { innerTextField ->
                        if (fieldValue.isEmpty()) {
                            Text(
                                text = hint,
                                fontSize = 14.sp,
                                fontFamily = fonts,
                                fontWeight = FontWeight.Normal,
                                color = hint_text_color,
                                modifier = Modifier.wrapContentHeight(Alignment.Bottom)
                            )
                        }
                        innerTextField()
                    }
                )
            } else {
                dropDownMenuList(items = dropDownList)
            }

            Divider(color = ColorDefault, thickness = 1.dp)
        }
    }
}

@Composable
fun ShowMore() {
    var show by remember {
        mutableStateOf("Show More")
    }

    var arrow by remember {
        mutableStateOf(true)
    }
    var up = R.drawable.ic_arrow_up
    var dowm = R.drawable.ic_arrow_down

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(.3f)
                .clickable {
                    if (show == "Show More") {
                        show = "Show Less"
                        arrow = false
                    } else {
                        show = "Show More"
                        arrow = true
                    }

                }
        ) {
            Text(
                text = show,
                style = TextStyle(
                    color = skyBlue,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fonts,
                    fontSize = 16.sp
                ),
            )

            Icon(
                painter = painterResource(id = if (arrow) dowm else up),
                tint = skyBlue,
                contentDescription = "Show More",
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.width(4.dp))

        Icon(
            painter = painterResource(id = R.drawable.ic_info_blue_24dp),
            tint = skyBlue,
            contentDescription = "Info",
            modifier = Modifier.size(24.dp)
        )

    }
}

@Composable
fun dropDownIcon(text: String, hint: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)
    ) {
        Text(
            text = if (text.isNullOrEmpty()) hint else text,
            style = TextStyle(
                color = if (text.isNullOrEmpty()) hint_text_color else ColorDefault,
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            ),
            modifier = Modifier
                .fillMaxWidth(.9f)
                .weight(1f)
                .padding(top = 8.dp)
                .clickable {}

        )

        Icon(
            painter = painterResource(id = R.drawable.ic_dropdown),
            tint = ColorDefault,
            contentDescription = "drop down",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 4.dp)
        )

    }
}

@Composable
fun dropDownMenuList(items: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    var selectedItem by remember { mutableStateOf(items[selectedIndex]) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .clickable { expanded = true }
    ) {
        Text(
            text = selectedItem,
            style = TextStyle(
                color = mediumBlack,
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 13.sp
            ),
            modifier = Modifier
                .fillMaxWidth(.9f)
                .weight(1f)
                .padding(top = 8.dp, start = 4.dp)
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_dropdown),
            tint = ColorDefault,
            contentDescription = "drop down",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 4.dp)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth(.8f)
                .background(White)
        ) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(

                    onClick = {
                        selectedItem = item
                        expanded = false
                        selectedIndex = index
                    },
                    modifier = Modifier.background(White),
                    text = {
                        if (expanded) {
                            Text(text = item)
                        }
                    }
                )

                if (index < items.size - 1) {
                    Divider(color = lightBlack, thickness = 0.3.dp)
                }
            }
        }

    }

}

@Preview
@Composable
fun FullScreenPreview() {
    FullScreen()
}

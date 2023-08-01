package com.example.jetpackcomoseui

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomoseui.ui.theme.Black
import com.example.jetpackcomoseui.ui.theme.ColorDefault
import com.example.jetpackcomoseui.ui.theme.light_green
import com.example.jetpackcomoseui.ui.theme.md_dark_green
import com.example.jetpackcomoseui.ui.theme.md_red_warning
import com.example.jetpackcomoseui.ui.theme.skyBlue
import com.example.jetpackcomoseui.ui.theme.ultralight_blue
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

@Composable
fun FullScreen() {
    LazyColumn(
        modifier = Modifier
            .background(Color.White)
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
                    .padding(4.dp)
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

    Surface(color = Color.White) {
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
                )
            }
        }
    }
}

@Composable
fun WorkOrderName() {
    var editText by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_workorder_small),
            contentDescription = "Name",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp, top = 6.dp)

        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "Name*",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                modifier = Modifier.padding(start = 8.dp)
            )

            BasicTextField(
                value = editText,
                onValueChange = { text -> editText = text },
                textStyle = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .height(32.dp),
                maxLines = 1
            )

            Divider(color = ColorDefault, thickness = 1.dp)
        }
    }
}

@Composable
fun Status() {
    var status by remember { mutableStateOf("") }

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
                .padding(start = 8.dp, top = 6.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "Status",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                modifier = Modifier.padding(start = 8.dp)
            )

            Text(
                text = status,
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clickable { }

            )

            Divider(color = ColorDefault, thickness = 1.dp)

        }
    }
}

@Composable
fun Assets() {
    var selectedAsset by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_asset_small),
            contentDescription = "Assets",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 6.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.fillMaxWidth(0.8f)) {
            Text(
                text = "Asset*",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                modifier = Modifier.padding(start = 8.dp)
            )

            Text(
                text = selectedAsset,
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clickable { }
            )

            Divider(color = ColorDefault, thickness = 1.dp)
        }

        Spacer(modifier = Modifier.width(16.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_qr_20),
            contentDescription = "Scan",
            modifier = Modifier
                .size(20.dp)
                .clickable {}
        )
    }
}

@Composable
fun Employee() {
    var employee by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_assignee_small),
            contentDescription = "Employee",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 6.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "Employee*",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                modifier = Modifier.padding(start = 8.dp)
            )

            Text(
                text = employee,
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clickable { }

            )

            Divider(color = ColorDefault, thickness = 1.dp)
        }
    }
}

@Composable
fun Teams() {
    var team by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_team),
            contentDescription = "Teams",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 12.dp)

        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "Team*",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                modifier = Modifier.padding(start = 6.dp)
            )

            Text(
                text = team,
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 8.dp)
                    .clickable { }

            )

            Divider(
                color = ColorDefault,
                thickness = 1.dp,
                modifier = Modifier.padding(start = 8.dp)
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
        Icon(
            painter = painterResource(id = R.drawable.ic_icon_calendar_20),
            contentDescription = "Due Date",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 12.dp, top = 6.dp)
        )

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
                ),
                modifier = Modifier
                    .padding(start = 8.dp)
            )

            Text(
                text = date,
                style = TextStyle(
                    color = Black,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                )
            )

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
                ),
                modifier = Modifier
                    .padding(start = 8.dp)
            )

            Text(
                text = time,
                style = TextStyle(
                    color = Black,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                ),
                modifier = Modifier
                    .padding(start = 16.dp)
            )

            Divider(color = ColorDefault, thickness = 1.dp)
        }
    }
}

@Composable
fun EstimatedTime() {
    var estimated by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_workorder_small),
            contentDescription = "Time",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "Estimated Time",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                modifier = Modifier.padding(start = 8.dp)
            )

            BasicTextField(
                value = estimated,
                onValueChange = { text -> estimated = text.replace(Regex("[^0-9]"),"") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .height(32.dp),
                maxLines = 1
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
        Icon(
            painter = painterResource(id = R.drawable.ic_category_small),
            contentDescription = "Category",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "Category",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                modifier = Modifier.padding(start = 6.dp)
            )

            Text(
                text = category,
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clickable { }

            )

            Divider(color = ColorDefault, thickness = 1.dp)
        }
    }
}

@Composable
fun Description() {
    var description by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_text_small),
            contentDescription = "Description",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "Description",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                modifier = Modifier.padding(start = 8.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                BasicTextField(
                    value = description,
                    onValueChange = { text -> description = text },
                    textStyle = TextStyle(
                        color = ColorDefault,
                        fontFamily = fonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.White)
                        .height(32.dp),
                    maxLines = 3
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

            Divider(color = ColorDefault, thickness = 1.dp)
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
        Image(
            painter = painterResource(id = R.drawable.ic_priority_small),
            contentDescription = "Priority",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp)
        )

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

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_tag_small),
            contentDescription = "Tags",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "Tags",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                modifier = Modifier.padding(start = 6.dp)
            )

            Text(
                text = tags,
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clickable { }

            )

            Divider(color = ColorDefault, thickness = 1.dp)
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
        Icon(
            painter = painterResource(id = R.drawable.ic_workorder_small),
            contentDescription = "checklist",
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "Checklist:",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                modifier = Modifier.padding(start = 6.dp)
            )

            Text(
                text = checklist,
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clickable { }

            )

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
}

@Composable
fun SparePartsList() {

    val sparePartsList = remember { listOf("", "") }

    LazyColumn {
        items(sparePartsList.size) { sparePart ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {}
        }
    }
}

@Composable
fun Attachments() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
    ) {
        Image(
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

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_icon_edit),
            contentDescription = "Custom Field",
            modifier = Modifier
                .size(24.dp)
                .padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "adka",
                style = TextStyle(
                    color = ColorDefault,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                ),
                modifier = Modifier.padding(start = 6.dp)
            )
            if (customField != "123") {
                BasicTextField(
                    value = fieldValue,
                    onValueChange = { text -> fieldValue = text },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .height(32.dp),
                    maxLines = 1
                )
            } else {
                Text(
                    text = fieldValue,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .clickable { }

                )
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
fun DropdownWithLine() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Gray),
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dropdown),
            contentDescription = "Drop Down",
            modifier = Modifier
                .size(24.dp)
                .padding(4.dp)
        )
    }
}

@Preview
@Composable
fun FullScreenPreview() {
    FullScreen()
}

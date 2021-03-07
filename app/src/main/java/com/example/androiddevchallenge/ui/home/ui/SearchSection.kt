package com.example.androiddevchallenge.ui.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

@Composable
fun SearchSection() {
    var textState by remember { mutableStateOf(TextFieldValue()) }
    Column {
        TitleSection(title = stringResource(id = R.string.search_pet))
        SearchBox(
            modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.ds_padding_large)),
            textFieldValue = textState,
            onTextChanged = { textState = it }
        )
    }
}

@Composable
fun SearchBox(
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    textFieldValue: TextFieldValue,
    onTextChanged: (TextFieldValue) -> Unit,
) {

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White),
        value = textFieldValue,
        onValueChange = onTextChanged,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Send
        ),
        placeholder = {
            Text(
                stringResource(id = R.string.enter_pet),
                style = MaterialTheme.typography.body1,
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Black
        ),
        leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = null) },
    )


}
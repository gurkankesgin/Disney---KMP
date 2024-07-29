package ui.screens.characterlist.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CharacterListItem(modifier: Modifier, imageUrl: String?, name: String?) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .background(Color.LightGray).padding(
                    horizontal = 16.dp, vertical = 8.dp
                ), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                modifier = Modifier.size(64.dp).clip(CircleShape),
                contentScale = ContentScale.Crop,
                model = imageUrl,
                contentDescription = null,
            )
            Text(
                name.orEmpty(), fontWeight = FontWeight.Black
            )
        }
    }
}


@Composable
@Preview
fun PreviewListItem() {
    CharacterListItem(
        imageUrl = "", name = "Test", modifier = Modifier.padding(16.dp)
    )
}
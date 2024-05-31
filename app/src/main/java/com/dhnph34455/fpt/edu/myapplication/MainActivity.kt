package com.dhnph34455.fpt.edu.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dhnph34455.fpt.edu.myapplication.Model.Movie
import com.dhnph34455.fpt.edu.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    var movies = listOf(
        Movie("Mai" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ." , "30/5/2024"),
        Movie("Kung Fu Panda 4" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
        Movie("Hành tinh cát" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
        Movie("Mai" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
        Movie("Kung Fu Panda 4" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
        Movie("Hành tinh cát" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
        Movie("Mai" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
        Movie("Kung Fu Panda 4" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
        Movie("Hành tinh cát" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    MovieScreen(movies = movies)
                    PreviewCinemaSeatBooking()
                }
            }
        }
    }
}

@Composable
fun MovieListRow(movies :List<Movie>) {
    LazyRow(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            MovieItem(movie = movies[index])
        }
    }
}

@Composable
fun MovieListGrid(movies: List<Movie>){
    val gridState = rememberLazyStaggeredGridState()
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        state = gridState,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalItemSpacing = 8.dp,
        contentPadding = PaddingValues(8.dp)
    ) {
        items(movies.size) { index ->
            MovieItem(movie = movies[index])
        }
    }
}

enum class ListType {
    ROW, COLUMN, GRID
}

@Composable
fun MovieScreen(movies: List<Movie>) {
    var listType by remember { mutableStateOf(ListType.ROW) }
    Column {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { listType = ListType.ROW }) {
                Text("Row")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { listType = ListType.COLUMN }) {
                Text("Column")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { listType = ListType.GRID }) {
                Text("Grid")
            }
        }
        when (listType) {
            ListType.ROW -> MovieListRow(movies)
            ListType.COLUMN -> MovieListColumn(movies)
            ListType.GRID -> MovieListGrid(movies)
        }
    }
}

@Composable
fun MovieListColumn(movies: List<Movie>) {
    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            MovieItemColumn(movie = movies[index])
        }
    }
}

@Composable
fun BoldValueText(label: String, value: String) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal)) {
                append(label)
            }
            withStyle(style = SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)) {
                append(value)
            }
        }
    )
}

@Composable
fun MovieItemColumn(movie: Movie) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor =
            Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation =
            6.dp
        ),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = movie.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(120.dp)
                    .wrapContentHeight()
            )
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2,

                    overflow = TextOverflow.Ellipsis

                )
                BoldValueText(label = "Thời lượng: ", value = movie.time+"'")
                BoldValueText(label = "Khởi chiếu: ", value = movie.startUp)
                Text(
                    text = "Tóm tắt nội dung",

                    style = MaterialTheme.typography.bodySmall,

                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        top = 4.dp, bottom =
                        2.dp
                    )
                )
                Text(
                    text = movie.describe,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 5,

                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(end = 2.dp)
                )
            }
        }
    }
}

@Composable
fun MovieItem(movie : Movie) {
    Card (colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)){
        Column (modifier = Modifier
            .width(175.dp)
            .height(330.dp)){
            AsyncImage(
                model = movie.imageUrl,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .height(255.dp)
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topEnd = 8.dp, topStart =
                            8.dp
                        )
                    ),
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = movie.title, style =
                MaterialTheme.typography.titleSmall, maxLines = 2)
                BoldValueText(label = "Thời lượng: ", value = movie.time+"'")
                BoldValueText(label = "Khởi chiếu: ", value = movie.startUp)
            }
        }
    }
}

@Preview
@Composable
fun PreviewMain(){
    var movie = listOf(
        Movie("Mai" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ." , "30/5/2024"),
        Movie("Kung Fu Panda 4" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
        Movie("Hành tinh cát" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
        Movie("Mai" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
        Movie("Kung Fu Panda 4" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
        Movie("Hành tinh cát" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
        Movie("Mai" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
        Movie("Kung Fu Panda 4" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
        Movie("Hành tinh cát" , "180" , "https://upload.wikimedia.org/wikipedia/vi/3/36/Mai_2024_poster.jpg" , "Mai (viết cách điệu: MɅI) là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn và đồng sản xuất, đánh dấu đây là bộ phim điện ảnh thứ ba anh làm đạo diễn, sau Bố già và Nhà bà Nữ.","30/5/2024"),
    )
    MovieScreen(movies = movie)
}

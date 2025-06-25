package com.starbucks.starbucksapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starbucks.starbucksapp.ui.theme.StarbucksCloneTheme
import com.starbucks.starbucksapp.ui.theme.StarbucksGreen
import com.starbucks.starbucksapp.ui.theme.StarbucksGold
import com.starbucks.starbucksapp.ui.theme.AccentYellow
import com.starbucks.starbucksapp.ui.theme.GrayBackground
import com.starbucks.starbucksapp.ui.theme.StarbucksCream // Import StarbucksCream

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StarbucksApp() {
    Scaffold(
        topBar = { AppHeader() },
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background) // Use theme background color
        ) {
            item {
                PromotionalBanner()
            }
            item {
                RewardSection()
            }
            item {
                QuickActions()
            }
            item {
                FeaturedItemsSection()
            }
            item {
                Spacer(modifier = Modifier.height(24.dp)) // Increased space at the bottom
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHeader() {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Star, // Placeholder for Starbucks logo
                    contentDescription = "Starbucks Logo",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(32.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = "Starbucks",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        actions = {
            IconButton(onClick = { /* Handle search click */ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
            IconButton(onClick = { /* Handle profile click */ }) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun PromotionalBanner() {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = AccentYellow),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp) // Adjusted padding
            .height(180.dp), // Slightly taller banner
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp) // Increased elevation
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp), // Increased inner padding
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "New Spring Drinks!",
                    style = MaterialTheme.typography.headlineMedium.copy(color = Color.White),
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.height(6.dp)) // Adjusted space
                Text(
                    text = "Try our refreshing new seasonal beverages and enjoy a taste of spring.",
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color.White.copy(alpha = 0.9f)),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(16.dp)) // Adjusted space
                Button(
                    onClick = { /* Handle learn more click */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = AccentYellow),
                    shape = RoundedCornerShape(16.dp), // More rounded button
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp) // Adjusted padding
                ) {
                    Text("Learn More", fontWeight = FontWeight.Bold, fontSize = 16.sp) // Larger text
                }
            }
            // Placeholder for an image
            Box(
                modifier = Modifier
                    .size(130.dp) // Slightly larger placeholder
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.LightGray) // Placeholder color
            ) {
                // You can add an icon or a more detailed placeholder here
            }
        }
    }
}

@Composable
fun RewardSection() {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Adjusted elevation
    ) {
        Column(
            modifier = Modifier.padding(20.dp) // Increased inner padding
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Starbucks® Rewards",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
                TextButton(onClick = { /* Handle view details click */ }) {
                    Text("View Details", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
                }
            }
            Spacer(modifier = Modifier.height(16.dp)) // Adjusted space
            LinearProgressIndicator(
                progress = 0.7f, // Example progress
                modifier = Modifier
                    .fillMaxWidth()
                    .height(12.dp) // Thicker progress bar
                    .clip(RoundedCornerShape(6.dp)), // More rounded progress bar
                color = StarbucksGold, // Progress color
                trackColor = GrayBackground // Background color of the progress bar
            )
            Spacer(modifier = Modifier.height(10.dp)) // Adjusted space
            Text(
                text = "You're 70 stars away from your next free drink!", // More descriptive text
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(16.dp)) // Adjusted space
            Button(
                onClick = { /* Handle Redeem Now click */ },
                colors = ButtonDefaults.buttonColors(containerColor = StarbucksGreen),
                shape = RoundedCornerShape(16.dp), // More rounded button
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 14.dp) // Adjusted padding
            ) {
                Text("Redeem Now", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp) // Larger text
            }
        }
    }
}

@Composable
fun QuickActions() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp) // Adjusted padding
    ) {
        Text(
            text = "Quick Actions",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp) // Increased padding
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            QuickActionButton(Icons.Default.MailOutline, "Order") { /* Handle Order */ }
            QuickActionButton(Icons.Default.LocationOn, "Stores") { /* Handle Store Locator */ } // Renamed to "Stores"
            QuickActionButton(Icons.Default.Notifications, "Offers") { /* Handle Offers */ }
            QuickActionButton(Icons.Default.Info, "Help") { /* Handle Help */ }
        }
    }
}

@Composable
fun QuickActionButton(icon: ImageVector, text: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(60.dp) // Slightly larger icon circle
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)), // Slightly stronger tint
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(36.dp) // Larger icon
            )
        }
        Spacer(modifier = Modifier.height(6.dp)) // Adjusted space
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

data class FeaturedItem(val id: Int, val name: String, val description: String, val price: String, val imagePlaceholderColor: Color)

@Composable
fun FeaturedItemsSection() {
    val featuredItems = remember {
        listOf(
            FeaturedItem(1, "Iced Latte", "Creamy espresso with cold milk and ice.", "$4.75", Color(0xFFC8E6C9)), // Light green
            FeaturedItem(2, "Butter Croissant", "Flaky, buttery pastry perfect for breakfast.", "$3.25", Color(0xFFFFECB3)), // Light yellow
            FeaturedItem(3, "Blueberry Muffin", "Moist muffin with juicy blueberries.", "$3.50", Color(0xFFBBDEFB)), // Light blue
            FeaturedItem(4, "Matcha Latte", "Smooth matcha with steamed milk.", "$5.25", Color(0xFFD1C4E9))  // Light purple
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp) // Adjusted padding
    ) {
        Text(
            text = "Featured Items",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp) // Increased padding
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp), // Increased spacing between cards
            contentPadding = PaddingValues(horizontal = 4.dp) // Add slight horizontal padding to the row itself
        ) {
            items(featuredItems) { item ->
                FeaturedItemCard(item)
            }
        }
    }
}

@Composable
fun FeaturedItemCard(item: FeaturedItem) {
    Card(
        shape = RoundedCornerShape(20.dp), // More rounded corners for cards
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Increased elevation
        modifier = Modifier
            .width(200.dp) // Slightly wider card
            .wrapContentHeight()
            .clickable { /* Handle item click */ }
    ) {
        Column(
            modifier = Modifier.padding(16.dp) // Increased inner padding
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp) // Slightly taller image placeholder
                    .clip(RoundedCornerShape(16.dp))
                    .background(item.imagePlaceholderColor)
            ) {
                // You could add a generic icon here if desired
            }
            Spacer(modifier = Modifier.height(12.dp)) // Adjusted space
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(6.dp)) // Adjusted space
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(12.dp)) // Adjusted space
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.price,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), // Larger price text
                    color = MaterialTheme.colorScheme.primary
                )
                Button(
                    onClick = { /* Add to cart */ },
                    colors = ButtonDefaults.buttonColors(containerColor = StarbucksGreen),
                    shape = RoundedCornerShape(12.dp), // More rounded add button
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp), // Adjusted padding
                    modifier = Modifier.wrapContentSize()
                ) {
                    Text("Add", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold) // Larger and bolder add text
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        Pair("Home", Icons.Default.Home),
        Pair("Order", Icons.Default.Menu),
        Pair("Stores", Icons.Default.LocationOn),
        Pair("Cards", Icons.Default.Star)
    )
    var selectedItem by remember { mutableStateOf(items[0].first) }

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)) // More rounded top corners
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.surface,
                        MaterialTheme.colorScheme.surface.copy(alpha = 0.98f) // Slightly less transparent for a more solid feel
                    )
                )
            )
            .heightIn(min = 72.dp) // Increased minimum height
    ) {
        items.forEach { (label, icon) ->
            val isSelected = selectedItem == label
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = label,
                        modifier = Modifier.size(28.dp) // Larger icons
                    )
                },
                label = {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.labelMedium, // Using labelMedium for better readability
                        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                selected = isSelected,
                onClick = { selectedItem = label /* Handle navigation */ },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f), // Slightly lighter unselected icons
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                    indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f) // Slightly more visible indicator
                )
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun StarbucksAppPreview() {
    StarbucksCloneTheme {
        StarbucksApp()
    }
}
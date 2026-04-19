# 1. Create the database
az mysql flexible-server db create \
  --resource-group $RESOURCE_GROUP \
  --server-name $MYSQL_SERVER \
  --database-name $DB_NAME

# 2. Configure Web App environment variables
az webapp config appsettings set \
  --resource-group $RESOURCE_GROUP \
  --name $APP_NAME \
  --settings \
    DB_HOST="${MYSQL_SERVER}.mysql.database.azure.com" \
    DB_NAME="$DB_NAME" \
    DB_USER="dbadmin" \
    DB_PASS="$MYSQL_PASSWORD"

# 3. Deploy the JAR file
az webapp deploy \
  --resource-group $RESOURCE_GROUP \
  --name $APP_NAME \
  --src-path target/Projekt2_Gruppe_2-0.0.1-SNAPSHOT.jar \
  --type jar

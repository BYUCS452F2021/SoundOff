using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;

namespace soundOff_api.Migrations
{
    public partial class initial : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            //migrationBuilder.AlterDatabase()
            //    .Annotation("MySql:CharSet", "utf8mb4");

            //migrationBuilder.CreateTable(
            //    name: "__EFMigrationsHistory",
            //    columns: table => new
            //    {
            //        MigrationId = table.Column<string>(type: "varchar(150)", maxLength: 150, nullable: false, collation: "utf8mb4_0900_ai_ci")
            //            .Annotation("MySql:CharSet", "utf8mb4"),
            //        ProductVersion = table.Column<string>(type: "varchar(32)", maxLength: 32, nullable: false, collation: "utf8mb4_0900_ai_ci")
            //            .Annotation("MySql:CharSet", "utf8mb4")
            //    },
            //    constraints: table =>
            //    {
            //        table.PrimaryKey("PRIMARY", x => x.MigrationId);
            //    })
            //    .Annotation("MySql:CharSet", "utf8mb4")
            //    .Annotation("Relational:Collation", "utf8mb4_0900_ai_ci");

            //migrationBuilder.CreateTable(
            //    name: "Attendances",
            //    columns: table => new
            //    {
            //        Id = table.Column<uint>(type: "int unsigned", nullable: false)
            //            .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn)
            //    },
            //    constraints: table =>
            //    {
            //        table.PrimaryKey("PK_Attendances", x => x.Id);
            //    })
            //    .Annotation("MySql:CharSet", "utf8mb4")
            //    .Annotation("Relational:Collation", "utf8mb4_0900_ai_ci");

            //migrationBuilder.CreateTable(
            //    name: "Classes",
            //    columns: table => new
            //    {
            //        Id = table.Column<uint>(type: "int unsigned", nullable: false)
            //            .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
            //        SectionNumber = table.Column<string>(type: "varchar(45)", maxLength: 45, nullable: true, collation: "utf8mb4_0900_ai_ci")
            //            .Annotation("MySql:CharSet", "utf8mb4")
            //    },
            //    constraints: table =>
            //    {
            //        table.PrimaryKey("PK_Classes", x => x.Id);
            //    })
            //    .Annotation("MySql:CharSet", "utf8mb4")
            //    .Annotation("Relational:Collation", "utf8mb4_0900_ai_ci");

            //migrationBuilder.CreateTable(
            //    name: "Codes",
            //    columns: table => new
            //    {
            //        Id = table.Column<uint>(type: "int unsigned", nullable: false)
            //            .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn)
            //    },
            //    constraints: table =>
            //    {
            //        table.PrimaryKey("PK_Codes", x => x.Id);
            //    })
            //    .Annotation("MySql:CharSet", "utf8mb4")
            //    .Annotation("Relational:Collation", "utf8mb4_0900_ai_ci");

            //migrationBuilder.CreateTable(
            //    name: "Enrollments",
            //    columns: table => new
            //    {
            //        Id = table.Column<uint>(type: "int unsigned", nullable: false)
            //            .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn)
            //    },
            //    constraints: table =>
            //    {
            //        table.PrimaryKey("PK_Enrollments", x => x.Id);
            //    })
            //    .Annotation("MySql:CharSet", "utf8mb4")
            //    .Annotation("Relational:Collation", "utf8mb4_0900_ai_ci");

            //migrationBuilder.CreateTable(
            //    name: "Professors",
            //    columns: table => new
            //    {
            //        Id = table.Column<uint>(type: "int unsigned", nullable: false)
            //            .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn)
            //    },
            //    constraints: table =>
            //    {
            //        table.PrimaryKey("PK_Professors", x => x.Id);
            //    })
            //    .Annotation("MySql:CharSet", "utf8mb4")
            //    .Annotation("Relational:Collation", "utf8mb4_0900_ai_ci");

            //migrationBuilder.CreateTable(
            //    name: "Students",
            //    columns: table => new
            //    {
            //        Id = table.Column<uint>(type: "int unsigned", nullable: false)
            //            .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn)
            //    },
            //    constraints: table =>
            //    {
            //        table.PrimaryKey("PK_Students", x => x.Id);
            //    })
            //    .Annotation("MySql:CharSet", "utf8mb4")
            //    .Annotation("Relational:Collation", "utf8mb4_0900_ai_ci");

            //migrationBuilder.CreateIndex(
            //    name: "Id_UNIQUE",
            //    table: "Attendances",
            //    column: "Id",
            //    unique: true);

            //migrationBuilder.CreateIndex(
            //    name: "Id_UNIQUE1",
            //    table: "Classes",
            //    column: "Id",
            //    unique: true);

            //migrationBuilder.CreateIndex(
            //    name: "Id_UNIQUE2",
            //    table: "Codes",
            //    column: "Id",
            //    unique: true);

            //migrationBuilder.CreateIndex(
            //    name: "Id_UNIQUE3",
            //    table: "Enrollments",
            //    column: "Id",
            //    unique: true);

            //migrationBuilder.CreateIndex(
            //    name: "Id_UNIQUE4",
            //    table: "Professors",
            //    column: "Id",
            //    unique: true);

            //migrationBuilder.CreateIndex(
            //    name: "Id_UNIQUE5",
            //    table: "Students",
            //    column: "Id",
            //    unique: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "__EFMigrationsHistory");

            migrationBuilder.DropTable(
                name: "Attendances");

            migrationBuilder.DropTable(
                name: "Classes");

            migrationBuilder.DropTable(
                name: "Codes");

            migrationBuilder.DropTable(
                name: "Enrollments");

            migrationBuilder.DropTable(
                name: "Professors");

            migrationBuilder.DropTable(
                name: "Students");
        }
    }
}

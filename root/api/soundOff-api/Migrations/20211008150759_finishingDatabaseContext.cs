using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace soundOff_api.Migrations
{
    public partial class finishingDatabaseContext : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "Email",
                table: "Students",
                type: "longtext",
                nullable: true,
                collation: "utf8mb4_0900_ai_ci")
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.AddColumn<string>(
                name: "Major",
                table: "Students",
                type: "longtext",
                nullable: true,
                collation: "utf8mb4_0900_ai_ci")
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.AddColumn<string>(
                name: "Name",
                table: "Students",
                type: "longtext",
                nullable: true,
                collation: "utf8mb4_0900_ai_ci")
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.AddColumn<string>(
                name: "Password",
                table: "Students",
                type: "longtext",
                nullable: true,
                collation: "utf8mb4_0900_ai_ci")
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.AddColumn<string>(
                name: "Phone",
                table: "Students",
                type: "longtext",
                nullable: true,
                collation: "utf8mb4_0900_ai_ci")
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.AddColumn<string>(
                name: "Degree",
                table: "Professors",
                type: "longtext",
                nullable: true,
                collation: "utf8mb4_0900_ai_ci")
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.AddColumn<string>(
                name: "Department",
                table: "Professors",
                type: "longtext",
                nullable: true,
                collation: "utf8mb4_0900_ai_ci")
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.AddColumn<string>(
                name: "Email",
                table: "Professors",
                type: "longtext",
                nullable: true,
                collation: "utf8mb4_0900_ai_ci")
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.AddColumn<string>(
                name: "Name",
                table: "Professors",
                type: "longtext",
                nullable: true,
                collation: "utf8mb4_0900_ai_ci")
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.AddColumn<string>(
                name: "Password",
                table: "Professors",
                type: "longtext",
                nullable: true,
                collation: "utf8mb4_0900_ai_ci")
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.AddColumn<uint>(
                name: "ClassId",
                table: "Enrollments",
                type: "int unsigned",
                nullable: true);

            migrationBuilder.AddColumn<uint>(
                name: "StudentId",
                table: "Enrollments",
                type: "int unsigned",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "AttendanceCode",
                table: "Codes",
                type: "longtext",
                nullable: true,
                collation: "utf8mb4_0900_ai_ci")
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.AddColumn<DateTime>(
                name: "ClassDate",
                table: "Codes",
                type: "datetime(6)",
                nullable: false,
                defaultValue: new DateTime(1, 1, 1, 0, 0, 0, 0, DateTimeKind.Unspecified));

            migrationBuilder.AddColumn<uint>(
                name: "ClassId",
                table: "Codes",
                type: "int unsigned",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "ClassName",
                table: "Classes",
                type: "longtext",
                nullable: true,
                collation: "utf8mb4_0900_ai_ci")
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.AddColumn<uint>(
                name: "ProfessorId",
                table: "Classes",
                type: "int unsigned",
                nullable: true);

            migrationBuilder.CreateIndex(
                name: "IX_Enrollments_ClassId",
                table: "Enrollments",
                column: "ClassId");

            migrationBuilder.CreateIndex(
                name: "IX_Enrollments_StudentId",
                table: "Enrollments",
                column: "StudentId");

            migrationBuilder.CreateIndex(
                name: "IX_Codes_ClassId",
                table: "Codes",
                column: "ClassId");

            migrationBuilder.CreateIndex(
                name: "IX_Classes_ProfessorId",
                table: "Classes",
                column: "ProfessorId");

            migrationBuilder.AddForeignKey(
                name: "FK_Classes_Professors_ProfessorId",
                table: "Classes",
                column: "ProfessorId",
                principalTable: "Professors",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_Codes_Classes_ClassId",
                table: "Codes",
                column: "ClassId",
                principalTable: "Classes",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_Enrollments_Classes_ClassId",
                table: "Enrollments",
                column: "ClassId",
                principalTable: "Classes",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_Enrollments_Students_StudentId",
                table: "Enrollments",
                column: "StudentId",
                principalTable: "Students",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Classes_Professors_ProfessorId",
                table: "Classes");

            migrationBuilder.DropForeignKey(
                name: "FK_Codes_Classes_ClassId",
                table: "Codes");

            migrationBuilder.DropForeignKey(
                name: "FK_Enrollments_Classes_ClassId",
                table: "Enrollments");

            migrationBuilder.DropForeignKey(
                name: "FK_Enrollments_Students_StudentId",
                table: "Enrollments");

            migrationBuilder.DropIndex(
                name: "IX_Enrollments_ClassId",
                table: "Enrollments");

            migrationBuilder.DropIndex(
                name: "IX_Enrollments_StudentId",
                table: "Enrollments");

            migrationBuilder.DropIndex(
                name: "IX_Codes_ClassId",
                table: "Codes");

            migrationBuilder.DropIndex(
                name: "IX_Classes_ProfessorId",
                table: "Classes");

            migrationBuilder.DropColumn(
                name: "Email",
                table: "Students");

            migrationBuilder.DropColumn(
                name: "Major",
                table: "Students");

            migrationBuilder.DropColumn(
                name: "Name",
                table: "Students");

            migrationBuilder.DropColumn(
                name: "Password",
                table: "Students");

            migrationBuilder.DropColumn(
                name: "Phone",
                table: "Students");

            migrationBuilder.DropColumn(
                name: "Degree",
                table: "Professors");

            migrationBuilder.DropColumn(
                name: "Department",
                table: "Professors");

            migrationBuilder.DropColumn(
                name: "Email",
                table: "Professors");

            migrationBuilder.DropColumn(
                name: "Name",
                table: "Professors");

            migrationBuilder.DropColumn(
                name: "Password",
                table: "Professors");

            migrationBuilder.DropColumn(
                name: "ClassId",
                table: "Enrollments");

            migrationBuilder.DropColumn(
                name: "StudentId",
                table: "Enrollments");

            migrationBuilder.DropColumn(
                name: "AttendanceCode",
                table: "Codes");

            migrationBuilder.DropColumn(
                name: "ClassDate",
                table: "Codes");

            migrationBuilder.DropColumn(
                name: "ClassId",
                table: "Codes");

            migrationBuilder.DropColumn(
                name: "ClassName",
                table: "Classes");

            migrationBuilder.DropColumn(
                name: "ProfessorId",
                table: "Classes");
        }
    }
}

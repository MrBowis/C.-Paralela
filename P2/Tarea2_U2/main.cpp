#include <omp.h>
#include <iostream>
#include <sys/time.h>
#include <stdio.h>
#include <math.h>
#include <conio.h>
#include <windows.h>
#include <vector>
#include <cstdlib>
#include <ctime>

#define RESET "\033[0m"
#define RED "\033[31m"
#define GREEN "\033[32m"
#define BLUE "\033[34m"

#define HIDE_CURSOR "\033[?25l"
#define SHOW_CURSOR "\033[?25h"

#define UP 72
#define DOWN 80
#define ENTER 13

double TR, TP;

void gotoxy(int x, int y);
int generarNumeroAleatorio(int min, int max);
std::vector<int> generarArreglo(int n);
int menu(const char *titulo, const char *opciones[], int n);
int busquedaBinariaR(const std::vector<int> &arr, int target, int left, int right);
bool busquedaBinariaP(std::vector<int> &arr, int target, int inicio, int final);

int main()
{
    std::cout << HIDE_CURSOR;

    bool salir = false;
    int resultado;
    int opcion;

    int numeroElementos = 1000000000, key;
    std::vector<int> A;

    struct timeval t0, t1;
    double tiempoP = 0;

    const char *titulo = "BUSQUEDA BINARIA";
    const char *opciones[] = {"Secuencial y Paralela",
                              "Busqueda Binaria (Secuencial)",
                              "Busqueda Binaria (Paralela)",
                              "Salir"};
    int n = 4;

    while (!salir)
    {
        opcion = menu(titulo, opciones, n);
        system("cls");
        switch (opcion)
        {
        case 1:
            key = generarNumeroAleatorio(1, numeroElementos);
            A = generarArreglo(numeroElementos);

            std::cout << "Numero a buscar: " << key << std::endl;
            gettimeofday(&t0, 0);
            busquedaBinariaR(A, key, 0, A.size() - 1);
            gettimeofday(&t1, 0);
            tiempoP = (t1.tv_sec - t0.tv_sec) + (t1.tv_usec - t0.tv_usec) / 1000000.0f;
            TR = tiempoP;
            printf("Tiempo de ejecucion (Secuencial): %1.3f ..\n", TR * 1000000);

            std::cout << "Numero a buscar: " << key << std::endl;
            gettimeofday(&t0, 0);
            std::cout << busquedaBinariaP(A, key, 0, A.size() - 1);
            gettimeofday(&t1, 0);
            tiempoP = (t1.tv_sec - t0.tv_sec) + (t1.tv_usec - t0.tv_usec) / 1000000.0f;
            TP = tiempoP;
            printf("Tiempo de ejecucion (paralelo): %1.3f ..\n", TP * 1000000);
            
            system("pause");
            break;
        case 2:
            key = generarNumeroAleatorio(1, numeroElementos);

            std::cout << "Numero a buscar: " << key << std::endl;
            gettimeofday(&t0, 0);
            busquedaBinariaR(A, key, 0, A.size() - 1);
            gettimeofday(&t1, 0);
            tiempoP = (t1.tv_sec - t0.tv_sec) + (t1.tv_usec - t0.tv_usec) / 1000000.0f;
            TR = tiempoP;
            printf("Tiempo de ejecucion (Secuencial): %1.3f ms\n", TR * 1000);
            system("pause");
            break;
        case 3:
            key = generarNumeroAleatorio(1, numeroElementos);
            std::cout << "Numero a buscar: " << key << std::endl;
            gettimeofday(&t0, 0);
            std::cout << busquedaBinariaP(A, key, 0, A.size() - 1);
            gettimeofday(&t1, 0);
            tiempoP = (t1.tv_sec - t0.tv_sec) + (t1.tv_usec - t0.tv_usec) / 1000000.0f;
            TP = tiempoP;
            printf("Tiempo de ejecucion (paralelo): %1.3f ms\n", TP * 1000);
            system("pause");
            break;
        case 4:
            salir = true;
            break;
        }
    }

    system("cls");
    std::cout << SHOW_CURSOR;
    return 0;
}

int menu(const char *titulo, const char *opciones[], int n)
{
    int opcion = 1;
    int tecla;
    bool salir = false;

    while (!salir)
    {
        system("cls");
        gotoxy(5, 3 + opcion);
        std::cout << RED << ">>" << RESET;
        gotoxy(15, 2);
        std::cout << GREEN << titulo << RESET;
        for (int i = 0; i < n; i++)
        {
            gotoxy(10, 4 + i);
            std::cout << BLUE << i + 1 << ") " << RESET << opciones[i];
        }
        do
        {
            tecla = getch();
        } while (tecla != UP && tecla != DOWN && tecla != ENTER);

        switch (tecla)
        {
        case UP: // Arriba
            opcion--;
            if (opcion < 1)
            {
                opcion = n;
            }
            break;
        case DOWN: // Abajo
            opcion++;
            if (opcion > n)
            {
                opcion = 1;
            }
            break;
        case ENTER: // Enter
            salir = true;
            break;
        }
    }
    gotoxy(0, 0);
    return opcion;
}

void gotoxy(int x, int y)
{
    COORD coord;
    coord.X = x;
    coord.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

std::vector<int> generarArreglo(int n)
{
    std::vector<int> A;
    for (int i = 0; i < n; i++)
    {
        A.push_back(i + 1);
    }
    return A;
}

int generarNumeroAleatorio(int min, int max)
{
    srand(static_cast<unsigned>(time(0)));
    int num = rand() % (max - min + 1) + min;
    return num;
}

bool busquedaBinariaP(std::vector<int> &arr, int target, int inicio, int final)
{
    int hilos = 8;
    omp_set_num_threads(hilos);
    int encontrado;
    int mid = (inicio + final) / 2;

#pragma omp parallel sections
    {
#pragma omp section
        {
            int respuesta = busquedaBinariaR(arr, target, mid + 1, mid);
#pragma omp atomic
            encontrado += respuesta;
        }
#pragma omp section
        {
            int respuesta = busquedaBinariaR(arr, target, mid, mid - 1);
#pragma omp atomic
            encontrado += respuesta;
        }
    }
    return encontrado;
}

int busquedaBinariaR(const std::vector<int> &arr, int target, int left, int right)
{
    if (left <= right)
    {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            return busquedaBinariaR(arr, target, mid + 1, right);
        else
            return busquedaBinariaR(arr, target, left, mid - 1);
    }
    return -1;
}
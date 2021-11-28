import './ListaTarefa.css';
import { useEffect, useState } from 'react';
import { Card, Checkbox,  TextField, Button, Fab } from '@material-ui/core';
import { findAllDone, findAllPending, save, updateToDone, updateToPending } from './tarefa-service';
import AddIcon from '@material-ui/icons/Add'

export function ListaTarefa({status}){

    const [ tarefas, setTarefa ] = useState([]);
    const [ isAdding, setIsAdding ] =  useState(false);
    const [ descricao, setDescricao ] = useState(null);

    async function findAll(){
        if(status){
            const tarefaFeita = await findAllDone();
            setTarefa(tarefaFeita);
        }else{
            const tarefaPendente = await findAllPending();
            setTarefa(tarefaPendente);
        }
    }

    useEffect(async () => {
        await findAll();
    }, []);

    async function onChange(target, tarefa){
    console.log(target);
        if(target.checked){
            await updateToDone(tarefa);
        }else{
            await updateToPending(tarefa);
        }
        await findAll();
    }

    function onClickToAdd(){
        setIsAdding(true);
    }

    async function onSave(){
        await save({
            descricao,
            status: false,
        })
        setIsAdding(false);
        await findAll();
    }

    return (

        <>
            <ul>
                {tarefas.filter(tarefa => tarefa.status === status).map(tarefa =>{
                    return (
                        <Card className={'item-list-card'} key={tarefa.id}>
                            <Checkbox checked={tarefa.status} value={tarefa.id} onChange={({target}) => onChange(target, tarefa)}></Checkbox>
                            {tarefa.descricao}
                        </Card>
                    )
                })}

                {isAdding && <Card className={'item-list-card'} key={0}>
                                <TextField
                                    autoFocus
                                    margin="dense"
                                    id="description"
                                    label="Description"
                                    type="text"
                                    fullWidth
                                    onChange={(event) => setDescricao(event.target.value)}
                                ></TextField>
                                <Button onClick={() => setIsAdding(false)} variant="contained" color="secondary">Cancelar</Button>
                                <Button onClick={() => onSave()} variant="contained" color="primary">
                                Aceitar</Button>
                            </Card>
                }
            </ul>

            {!status && <Fab onClick={onClickToAdd} className={'fab-button'} color='primary' aria-label="Add"><AddIcon/></Fab>}

        </>

    );

}